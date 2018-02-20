/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $('#filechoose').change(function () {
            if (this.files && this.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $('#imageShow').attr('src', e.target.result);
                };
                reader.readAsDataURL(this.files[0]);
            }

        });
    $('.dropdown-menu a').click(function () {
        console.log($(this).attr('data-value'));
        $(this).closest('.dropdown').find('input.countrycode')
            .val($(this).attr('data-value'));
    });
//    $('#headerPage').load('header.html');
//    $('#page-add').load('add.jsp');
//    $('#tableAdd1').DataTable();
//    $('#tableAdd1').DataTable().columns().every(function (){
//       var that=this;
//    });
//    $('#resultSearch1').on('keyup change',function (e){
//             alert('Changed!');
//    });

//    $.get('admin.jsp', function (data) {
//        $('#page-wrapper').html(data.toString());
//    });
//    $('#page-wrapper').load('add.jsp',function (response){
//        $('#page-wrapper').html(response);
//    });
});
