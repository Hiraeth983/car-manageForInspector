let complaintList = [];

// 生成模板
function generateStr(data) {
    // 定义变量,存储生成的字符串内容,使用 += 拼接字符串形式
    let str = '';

    for (let i = 0; i <= data.length - 1; i++) {
        // 外层循环生成tr标签,循环几次,就生成几个tr标签
        // 因为tr标签中还要有td内容,要将两个tr标签,分开,写成拼接的形式
        str += '<tr>';

        str += `<td style="text-align: center">` + data[i]['orderId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['submitTime'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['staffId'] + `</td>`;
        if (data[i]['result'] === '') {
            str += `<td style="text-align: center">` + '未人工审批' + `</td>`;
        } else {
            str += `<td style="text-align: center">` + '已人工审批' + `</td>`;
        }
        str += `<td style="text-align: center">
                    <a class="btn btn-info btn-sm" onclick="appeal()">
                        <i class="fas fa-sign" style="margin-right: 5px;"></i>申诉
                    </a>
                </td>`;
        str += `<td style="text-align: center">
                        
                        <a class="btn btn-info btn-sm"  data-toggle="modal" data-target="#R` + data[i]['orderId'] + `">
                              <i class="fas fa-edit" style="margin-right: 5px;"></i>详情
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="R` + data[i]['orderId'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left">详细信息</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">描述</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="complaintDescribe" disabled>` + data[i]['complaintDescribe'] + `</textarea>
                                            </div>
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

function appeal() {
    let msg = "您确定要申诉吗？此行为会提交管理员\n\n请确认！";
    if (confirm(msg) === true) {
        alert("您已成功提交申诉！");
    } else {
        alert("取消申诉成功！");
    }
}

$(function () {
    $.ajaxSettings.async = false; // ajax同步处理
    $.ajax({
        url: 'getComplaintListByStaffId',
        type: 'post',
        dataType: 'json',
        data: {
            staffId
        },
        success: function (data) {
            complaintList = data;
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
            }
        }
    });

    $('#refresh').click(function () {
        $.ajax({
            url: 'getComplaintListByStaffId',
            type: 'post',
            dataType: 'json',
            data: {
                staffId
            },
            success: function (data) {
                complaintList = data;
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
                }
            }
        });
    });

});