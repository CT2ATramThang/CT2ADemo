
<div class="panel panel-primary" style="width: auto; margin-left: -16px; margin-top: 50px;">
            <div class="panel-heading" id="dang_nhap" style="cursor: pointer; background-color: #3C3F44; " >
                <span onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Đăng nhập</span>
            </div>
            <div id="id01" class="modal">
                <form class="modal-content animate" style="width: 40%;border-radius: 10px;background-color: #8a6d3b;" action="?menu=exec_dang_nhap" method="post">
                    <div class="imgcontainer">
                        <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                    </div>

                    <div style="margin-top: 50px;">

                        <label for="user" style="display: flex; justify-content: center;">Tên đăng nhập:</label>
                        <input type="text" style="width: 40%;font-family: Ubuntu-Regular;
                               font-size: 20px;
                               color: #555555;
                               line-height: 1.2;
                               display: block;
                               width: 80%;
                               height: 30px;
                               background: transparent;
                               padding: 0 10px 0 80px;
                               -webkit-transition: all 0.4s;
                               -o-transition: all 0.4s;
                               -moz-transition: all 0.4s;
                               transition: all 0.4s;
                               margin-left: 60px;" 
                               class="form-control"  name="username" id="user" placeholder="Nhập tên đăng nhập.." required >


                        <label for="pass" style="display: flex; justify-content: center;">Mật khẩu:</label>
                        <input type="password" style="width: 40%;font-family: Ubuntu-Regular;
                               font-size: 20px;
                               color: #555555;
                               line-height: 1.2;
                               display: block;
                               width: 80%;
                               height: 30px;
                               background: transparent;
                               padding: 0 10px 0 80px;
                               -webkit-transition: all 0.4s;
                               -o-transition: all 0.4s;
                               -moz-transition: all 0.4s;
                               transition: all 0.4s;
                               margin-left: 60px;" 
                               class="form-control"  name="password" id="pass" placeholder="Nhập mật khẩu.." required >


                        <input colspan="2" style="padding-top: 8px;display: -webkit-box;
                                            display: -webkit-flex;
                                            display: -moz-box;
                                            display: -ms-flexbox;
                                            display: flex;
                                            justify-content: center;
                                            align-items: center;
                                            padding: 0 20px;
                                            min-width: 244px;
                                            height: 50px;
                                            font-family: Poppins-Medium;
                                            font-size: 16px;
                                            color: #fff;
                                            line-height: 1.2;
                                            outline: none !important;
                                            border: none;
                                            background: rgba(0, 0, 0, .075);
                                            margin-left: 30%;
                                            margin-top: 20px;" 
                                            type="submit" class="btn btn-primary" name="submit" value="Đăng nhập"></td>
                        <a href="?menu=dang_ky" style="font-family: Poppins-Regular;
                                font-size: 18px;
                                color: #666666;
                                line-height: 1.4; margin-left: 80%;">Đăng ký<i class="fa fa-long-arrow-right m-l-5"></i></a>
                    </div>
                </form>

            </div>
            <script>
                // Get the modal
                var modal = document.getElementById('id01');

                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function (event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }
            </script>
            
        </div>


<!-- Modal -->
