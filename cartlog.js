
// var x;
// $(document).on('click', '.quantity', function()
// {
//     x=$(this).attr('id');
//     console.log(x);
// })


function minus(){
    let id=document.getElementsByClassName("quantity");
    var ht=id.id;
    let quantity=document.getElementsByClassName("number")[0];
    // for(let i=0;i<id.length;i++)
    // {
        
    //     var now=parseInt(quantity[ht].value, 10);
    //     now = isNaN(now) ? 0 : now;
    //     if(now>1)
    //     {
    //         now--;
    //     }
       
    
    //     quantity[ht].value=now;
    // }
    var now=parseInt(quantity.value,10);
    now = isNaN(now) ? 0 : now;
    if(now>1)
    {
        now--;
    }
   

    quantity.value=now;

    console.log(id.id);
}

function add(){
    let quantity=document.getElementsByClassName("number")[0];
    var now=parseInt(quantity.value,10);
    now = isNaN(now) ? 0 : now;
    now++;
   

    quantity.value=now;

    console.log(quantity.value);
}