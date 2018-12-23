/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 $(document).ready(function () {
                $('#submit1').click(function (e) {


               quantnew = $('#select1').val();
               alert(quantnew);
               e.preventDefault();
               $.ajax({
                  url:'http://localhost:8080/StoreWarehouse/insertStock/${stock.quantity}/${wrapped.product.productCode}/'+quantnew+'.htm',
                  type: 'GET',
                  contentType: 'application/json',

                  success: function (quant) {
                  $('#stock').text(quant);


                        }
                    });
                });
            });
