/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () { // Οταν φορτώσει η σελίδα τρέξε....
                $("#text1").keyup(function () { // Βάλε handler στο input type
                    var text = $(this).val(); // Το κείμενο τοy χρήστη
                    // alert(text);
                    $.ajax({
                        url:'searchwithajax.htm?text=' + text,
                        contentType: 'application/json',
                        success: function (result) {
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