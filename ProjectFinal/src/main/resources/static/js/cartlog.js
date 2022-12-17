function minus() {
  let quantity = document.getElementsByClassName("number");
  for (i = 0; i < quantity.length; i++) {
    var now = parseInt(quantity[i].value, 10);
    now = isNaN(now) ? 0 : now;
    if (now > 1) {
      now--;
    }

    quantity[i].value = now;
    console.log(quantity.value);
  }
}

function add() {
  let quantity = document.getElementsByClassName("number");
  var now = parseInt(quantity.value, 10);
  now = isNaN(now) ? 0 : now;
  now++;

  quantity.value = now;

  console.log(quantity.value);
}
