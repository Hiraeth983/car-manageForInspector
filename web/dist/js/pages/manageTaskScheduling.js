let applicationList = [];
let newList = [];

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

function getStaffNameList() {
    let staffNameList = '';
    $.ajax({
        url: 'getStaffListByStationId',
        type: 'post',
        dataType: 'json',
        data: {
            stationId
        },
        success: function (data) {
            staffList = data;
            console.log(staffList);
            for (let j = 0; j < data.length; j++) {
                staffNameList += `<option value='` + data[j].staffId + '-' + data[j].fullName + `'>` + data[j].staffId + '-' + data[j].fullName + `</option>`;
            }
            // console.log(staffName);
        }
    });
    // console.log(staffNameList);
    return staffNameList;
};

function check(obj) {
    // console.log(obj.orderId.value);
    // console.log(obj.selectStaff.value);
    // console.log(obj.reason.value);
    if(obj.state.value === '已同意' || obj.state.value === '已拒绝'){
        alert('当前申请已受理，无法修改！');
        return false;
    }
    let staff = obj.selectStaff.value;
    let temp = staff.split("-");
    $.ajax({
        url: 'updateApplicationByOrderId',
        type: 'post',
        dataType: 'json',
        data: {
            orderId:obj.orderId.value,
            nStaffId:temp[0],
            nStaffName:temp[1],
            reason:obj.reason.value,
            staffId
        },
        success: function (data) {
            applicationList = data;
            // console.log(recordList);
            let tb = document.getElementById('tb');
            if (data === '暂无数据') {
                tb.innerHTML = '';
                $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            } else {
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                $(".selectpicker").selectpicker("refresh");
            }
        }
    });
    // console.log(obj.phone.value);
    return false;
}

function clickDelete(orderId){
    $.ajax({
        url: 'deleteApplicationByOrderId',
        type: 'post',
        dataType: 'json',
        data: {
            orderId,
            staffId
        },
        success: function (data) {
            applicationList = data;
            // console.log(recordList);
            let tb = document.getElementById('tb');
            if (data === '暂无数据') {
                tb.innerHTML = '';
                $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            } else {
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                $(".selectpicker").selectpicker("refresh");
            }
        }
    });
}

// 生成模板
function generateStr(data) {
    // 定义变量,存储生成的字符串内容,使用 += 拼接字符串形式
    let str = '';

    for (let i = 0; i <= data.length - 1; i++) {
        // 外层循环生成tr标签,循环几次,就生成几个tr标签
        // 因为tr标签中还要有td内容,要将两个tr标签,分开,写成拼接的形式
        str += '<tr>';

        // str += `<td style="text-align: center">` + data[i]['orderId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['submitTime'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['oStaffId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['oStaffName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['nStaffId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['nStaffName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['state'] + `</td>`;
        str += `<td style="text-align: center">
                        <a class="col-2" href="javascript:void(0);" onclick="clickDelete(` + data[i]['orderId'] + `)" id="delete">
                            <i class="nav-icon far fa-trash-alt" title="删除"></i>
                        </a>
                        <a class="col-2" data-toggle="modal" data-target="#R` + data[i]['orderId'] + `">
                            <i class="nav-icon far fa-edit" title="修改"></i>
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="R` + data[i]['orderId'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left">修改</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" onsubmit="return check(this)">
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">单号</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['orderId'] + `"
                                                       name="orderId" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">申请状态</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['state'] + `"
                                                       name="state" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">提交时间</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['submitTime'] + `"
                                                       name="submitTime" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">指定员工</label>
                                            <div class="col-sm-10">
                                                <select class="selectpicker"
                                                    name="selectStaff"
                                                    data-live-search="true"
                                                    data-style="btn-info"
                                                    title="请选择员工姓名"
                                                    data-live-search-placeholder="搜索员工姓名">`;
        str += getStaffNameList();
        str += `</select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">申请原因</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control"
                                                       name="reason" >` + data[i]['reason'] + `</textarea>
                                            </div>
                                        </div>
                                        
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button type="submit" class="btn btn-primary">提交修改</button>
                                        </div>
                                    </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>`;
        str += '</tr>';
    }
    return str;
};


$(function () {
    $.ajaxSettings.async = false; // ajax同步处理
    $.ajax({
        url: 'getApplicationListByStaffId',
        type: 'post',
        dataType: 'json',
        data: {
            staffId
        },
        success: function (data) {
            applicationList = data;
            // console.log(recordList);
            let tb = document.getElementById('tb');
            if (data === '暂无数据') {
                tb.innerHTML = '';
                $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            } else {
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                $(".selectpicker").selectpicker("refresh");
            }
        }
    });

    $('#refresh').click(function (e) {
        e.preventDefault();
        $.ajax({
            url: 'getApplicationListByStaffId',
            type: 'post',
            dataType: 'json',
            data: {
                staffId
            },
            success: function (data) {
                applicationList = data;
                // console.log(recordList);
                let tb = document.getElementById('tb');
                if (data === '暂无数据') {
                    tb.innerHTML = '';
                    $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                } else {
                    $("#noData").html('');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                    $(".selectpicker").selectpicker("refresh");
                }
            }
        });
    });



});