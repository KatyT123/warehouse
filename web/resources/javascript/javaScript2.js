/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 $(document).ready(function () { // Οταν φορτώσει η σελίδα τρέξε....
                $('a').click(function(e) {
                    e.preventDefault(); // stops the default action of clicking on the link
                    var pageToLoad = $(this).attr('href'); // gets the href of the clicked link
                    $('#content').load(pageToLoad); // loads the remote page into the content div without refresh
                     var urllink = $("#content.value");
                    $.ajax({
                        url:urllink,
                        contentType: 'application/json',
                        success: function (products) {
                            $("#ajaxoutput").empty();
                            var jsonobj = $.parseJSON(result);

                            $.each(jsonobj, function (i, item) {
                                $tr = $('<tr>').append(
                                        $('<td>').text(item.name),
                                        $('<td>').text(item.surname)

                                        );
                                $("#ajaxoutput").append($tr);
                            });
                        }
                    });
                });
            });
             
