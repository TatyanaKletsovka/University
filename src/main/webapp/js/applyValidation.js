var markChecked = false;
var certificateChecked = false;

var markRegEx = /([0-9]|([1-9][0-9])|100)/;

var minMarkLength = 1;
var notFoundIndex = -1;

var minBall = 0;
var maxBall = 100;


var mark0 = document.getElementById("mark_id0");
var mark1 = document.getElementById("mark_id1");
var mark2 = document.getElementById("mark_id2");
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

var checkMark0 = function () {
    if (mark0.value < 0 || mark0.value > 100 || mark0.value.length < 1) {
        notValidColor(mark0);
    } else {
        validColor(mark0);
        markChecked = true;
    }
    submitChange();
};

var checkMark1 = function () {
    if (mark1.value < 0 || mark1.value > 100 || mark1.value.length < 1) {
        notValidColor(mark1);
    } else {
        validColor(mark1);
        markChecked = true;
    }
    submitChange();
};

var checkMark2 = function () {
    if (mark2.value < 0 || mark2.value > 100 || mark2.value.length < 1) {
        notValidColor(mark2);
    } else {
        validColor(mark2);
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
