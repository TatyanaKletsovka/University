var markChecked = false;
var certificateChecked = false;

var markRegEx = /([0-9]|([1-9][0-9])|100)/;

var minMarkLength = 1;
var notFoundIndex = -1;

var minBall = 0;
var maxBall = 100;


var mark = document.getElementById("mark_id");
var certificate = document.getElementById("certificate_id");
var submit = document.getElementById("submit");

var submitChange = function () {
    if (markChecked && certificateChecked) {
        submit.disabled = false;
        submit.classList.add("active");
    } else {
        submit.disabled = true;
        submit.classList.remove("active");
    }
};

var validColor = function (element) {
    element.classList.add("valid");
    element.classList.remove("notValid");
}

var notValidColor = function (element) {
    element.classList.add("notValid");
    element.classList.remove("valid");
}

var checkMark = function () {
    if (mark.value < 0 || mark.value > 100 || mark.value.length < 1) {
        notValidColor(mark);
    } else {
        validColor(mark);
        markChecked = true;
    }
    submitChange();
};

var checkCertificate = function () {
    if (certificate.value < 0 || certificate.value > 100 || certificate.value.length < 1) {
        notValidColor(certificate);
        certificateChecked = false;
    } else {
        validColor(certificate);
        certificateChecked = true;
    }
    submitChange();
};
