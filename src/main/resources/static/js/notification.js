function closeNotification() {
    var notification = document.getElementById("notification");
    notification.style.display = "none";
}

function notificationCloser() {
    var button = document.getElementById("notification-btn");
    button.addEventListener("click", closeNotification);
}

document.addEventListener('DOMContentLoaded', function() {
    notificationCloser();
});

setTimeout(function () {
            closeNotification();
        }, 5000);

function closeNotification2() {
    var notification = document.getElementById("error-notification");
    notification.style.display = "none";
}

function notificationCloser2() {
    var button = document.getElementById("error-notification-btn");
    button.addEventListener("click", closeNotification2);
}

document.addEventListener('DOMContentLoaded', function() {
    notificationCloser2();
});

setTimeout(function () {
            closeNotification2();
        }, 5000);




