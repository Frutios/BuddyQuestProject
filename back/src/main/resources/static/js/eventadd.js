
    $('input[name="startTime"]').daterangepicker({
        "singleDatePicker": true,
        "timePicker": true,
        "timePicker24Hour": true,
        "startDate": moment().startOf('hour'),
        "drops": "up",
        locale: {
            format: 'YYYY-MM-DD HH:mm'
        }
    });
    $('input[name="endTime"]').daterangepicker({
        "singleDatePicker": true,
        "timePicker": true,
        "timePicker24Hour": true,
        "startDate": moment().startOf('hour'),
        "drops": "up",
        locale: {
            format: 'YYYY-MM-DD HH:mm'
        }
    });

    function isNumber(evt) {
        evt = (evt) ? evt : window.event;
        var charCode = (evt.which) ? evt.which : evt.keyCode;
        if (charCode > 31 && (charCode < 48 || charCode > 57)) {
            return false;
        }
        return true;
    }