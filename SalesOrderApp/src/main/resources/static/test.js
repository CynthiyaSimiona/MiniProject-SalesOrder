debugger;
const url = 'http://localhost:8080/sales/getall';
  
  fetch(url)
    .then(function (resp) {
      console.log(resp)
      return resp.json()
    })
    .then(function (jsonResponse) {
      $('#results')
        .html(buildList(jsonResponse.results));
    })
    .catch(function (err) {
      alert('ERROR!');
    })
});


function buildList(order) {
  let rv = '';
  
  for (let i = 0; i < order.length; i++) {
    const item = order[i];
    rv += '
      <table id="myTable">
      <tr>
      <td> ${ item.orderid }</td>
       <td> ${ item.customer.id }</td>
       <td> ${ item.product.pcode }</td>
       <td> ${ item.quantity}</td> 
        
      </table>
    ';
  }
  
  return rv;
} 













