// ! input > date
let date = document.getElementById("nav_date");
date.value = new Date().toISOString().substring(0, 10);

// ! tab menu
const tabList = document.querySelectorAll(".tab_menu .tab_btn li");
for (let i = 0; i < tabList.length; i++) {
    tabList[i].querySelector(".tab_btns").addEventListener("click", function (changeTab) {
        changeTab.preventDefault();
        for (let j = 0; j < tabList.length; j++) {
            tabList[j].classList.remove("tab_menus");
        }
        this.parentNode.classList.add("tab_menus");
    });
}

// ! Canvas
const canvas = document.getElementById("boneCanvas");
const ctx = canvas.getContext("2d");

// start__image uploader
const reader = new FileReader();
const img = new Image();
const uploadImage = (upload) => {
    reader.onload = () => {
        img.onload = () => {
            canvas.width = img.width;
            canvas.height = img.height;
            ctx.drawImage(img, 0, 0);
        };
        img.src = reader.result;
    };
    reader.readAsDataURL(upload.target.files[0]);
};
const imageLeader = document.getElementById("uploader");
imageLeader.addEventListener("change", uploadImage);
// image uploader__end
// image download

// start__coordinate
function coordinate(event) {
    let xy = document.getElementById("xy");
    let x = event.offsetX; // X-coordinate
    let y = event.offsetY; // y-coordinate\
    console.log(x, y); //좌표찍기
    xy.innerText = x + " " + y;

    if (!pointMode) {
        ctx.lineTo(x, y);
        ctx.stroke();
    } else {
        ctx.beginPath();
        ctx.moveTo(x, y);
    }
}
// coordinate__end

// start__sidebar
const mode = document.getElementsByClassName("menu_i");
function handelModeClick(event) {
    if (pointMode === true) {
        pointMode = false;
    } else {
        pointMode = true;
    }
}

// draw point
let pointMode = false;

function pointClick() {
    if (canvas.getContext) {
        ctx.beginPath();
        ctx.arc(0, 0, 100, 0, 2 * Math.PI);
        ctx.fill();
    }
}
// sidebar__end

if (canvas) {
    canvas.addEventListener("mousemove", coordinate); // 캔버스 안 마우스 움직임
    canvas.addEventListener("mousedown", startPoint); // 마우스 클릭
    canvas.addEventListener("mouseup", stopPoint);
    canvas.addEventListener("mouseleave", stopPoint);
    //canvas.addEventListener("click", handleCanvasClick); // 포인터
}

if (mode) {
    mode.addEventListener("click", handelModeClick);
}

// 1. 저버튼을 누른다
// 2. 클릭시 해당좌표(coordinate의 x,y)에 점이 찍힌다.(곧 이벤트함수를 써야한다)
// 3. 저 버튼이 눌러있는 동안은 항상 점이 찍힌다
// 4. 저 버튼을 또 누르면 비활성
