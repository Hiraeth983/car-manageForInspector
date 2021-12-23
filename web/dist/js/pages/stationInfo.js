$(function () {
    console.log(stationId);
    console.log(staffId);

    $.ajax({
        url: 'getStaffByStaffId',
        type: 'post',
        dataType: 'json',
        data: {
            staffId,
            stationId
        },
        success: function (data) {
            $('#fullName').text(data[0].fullName);
            $('#fullName2').val(data[0].fullName);
            $('#stationId').text(data[0].stationId);
            $('#stationId2').val(data[0].stationId);
            $('#staffId').text(data[0].staffId);
            $('#staffId2').val(data[0].staffId);
            $('#orderSum').text(data[0].orderSum);
            $('#orderSum2').val(data[0].orderSum);
            $('#password').val(data[0].password);
            $('#avgScore').val(data[0].avgScore);
            $('#isAble').val(data[0].isAble == '0' ? '无' : '有');
        }
    });
})