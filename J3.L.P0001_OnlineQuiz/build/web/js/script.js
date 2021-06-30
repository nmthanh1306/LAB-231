var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
    showSlides(slideIndex += n);
}

/*
 * this function to show each question
 * @param {type} duration
 * @returns {undefined}
 */
function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");

    if (n > slides.length) {
        slideIndex = 1;
    }
    if (n < 1) {
        slideIndex = slides.length;
    }
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    if (slideIndex === 1) {
        document.getElementById("btn-prev").style.display = "none";
        document.getElementById("btn-next").style.display = "block";
        document.getElementById("btn-submit").style.display = "none";
    } else if (slideIndex === slides.length) {
        document.getElementById("btn-next").style.display = "none";
        document.getElementById("btn-submit").style.display = "block";
        document.getElementById("btn-prev").style.display = "block";
    } else {
        document.getElementById("btn-submit").style.display = "none";
        document.getElementById("btn-prev").style.display = "block";
        document.getElementById("btn-next").style.display = "block";

    }

    slides[slideIndex - 1].style.display = "block";
}


/**
 * function to count down time base on minute(number of question)
 * @param {type} duration 
 * */
function startTimer(duration) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        document.getElementById('countDown').innerHTML = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = duration;
        }
    }, 1000);
}
//
//fuction a(){
//    string b= string.replace(/\s\s+/g, ' ');
//}