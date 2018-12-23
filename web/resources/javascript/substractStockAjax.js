/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
                $('#submit2').click(function (e) {


               quantnew = $('#select2').val();
               alert(quantnew);
               e.preventDefault();
               $.ajax({
                  url:'http://localhost:8080/StoreWarehouse/substractStock/${stock.quantity}/${wrapped.product.productCode}/'+quantnew+'.htm',
                  type: 'GET',
                  contentType: 'application/json',

                  success: function (quant) {
                      if (quant.val()< $('#select2').val()) {
                         alert("The existing stock is less than the substracted!")
                      }
                     $('#stock').text(quant);

                        }
                    });
                });
            });

