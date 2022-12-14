

function minus(){
    let quantity=document.getElementById("number");
    var now=parseInt(quantity.value,10);
    now = isNaN(now) ? 0 : now;
    if(now>1)
    {
        now--;
    }
   

    quantity.value=now;

    console.log(quantity.value);
}

function add(){
    let quantity=document.getElementById("number");
    var now=parseInt(quantity.value,10);
    now = isNaN(now) ? 0 : now;
    now++;
   

    quantity.value=now;

    console.log(quantity.value);
}