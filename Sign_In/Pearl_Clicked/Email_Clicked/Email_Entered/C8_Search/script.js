/*VARIABLES*/

canvas = document.getElementsByTagName("canvas")[0];

var ctx = canvas.getContext("2d");

/*Modify options here*/

//possible characters that will appear
var characterList = ["."];

//stocks possible character attributes
var layers = {
  n: 4, //number of layers
  letters: [100, 70, 50, 30], //letters per layer (starting from the deepest layer)
  coef: [0.1, 0.2, 0.4, 0.6], //how much the letters move from the mouse (starting from the deepest layer)
  size: [2, 2, 2, 3], //font size of the letters (starting from the deepest layer)
  color: ["#fff", "#eee", "#fff", "#ccc"], //color of the letters (starting from the deepest layer)
  font: "Courier", //font family (of every layer)
};

/*End of options*/

var characters = [];
var mouseX = document.body.clientWidth;
var mouseY = document.body.clientHeight;

var rnd = {
  btwn: function (min, max) {
    return Math.floor(Math.random() * (max - min) + min);
  },
  choose: function (list) {
    return list[rnd.btwn(0, list.length)];
  },
};

/*LETTER DRAWING*/

function drawLetter(char) {
  ctx.font = char.size + "px " + char.font;
  ctx.fillStyle = char.color;

  var x = char.posX + (mouseX - canvas.width) * char.coef;
  var y = char.posY + (mouseY - canvas.height) * char.coef;

  ctx.fillText(char.char, x, y);
}

/*ANIMATION*/

document.onmousemove = function (ev) {
  mouseX = ev.pageX - canvas.offsetLeft;
  mouseY = ev.pageY - canvas.offsetTop;

  if (window.requestAnimationFrame) {
    requestAnimationFrame(update);
  } else {
    update();
  }
};

function update() {
  clear();
  render();
}

function clear() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
}

function render() {
  for (var i = 0; i < characters.length; i++) {
    drawLetter(characters[i]);
  }
}

/*INITIALIZE*/

function createLetters() {
  for (var i = 0; i < layers.n; i++) {
    for (var j = 0; j < layers.letters[i]; j++) {
      var character = rnd.choose(characterList);
      var x = rnd.btwn(0, canvas.width);
      var y = rnd.btwn(0, canvas.height);

      characters.push({
        char: character,
        font: layers.font,
        size: layers.size[i],
        color: layers.color[i],
        layer: i,
        coef: layers.coef[i],
        posX: x,
        posY: y,
      });
    }
  }
}

createLetters();
update();

/*REAJUST CANVAS AFTER RESIZE*/

window.onresize = function () {
  location.reload();
};

document.getElementById("close").onclick = function () {
  this.parentElement.style.visibility = "hidden";
  this.parentElement.style.opacity = "0";
};
