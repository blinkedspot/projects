<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <title>jQuery File Upload Example</title>
        <script src="js/jquery-1.9.1.min.js"></script>

        <script src="js/vendor/jquery.ui.widget.js"></script>
        <script src="js/jquery.iframe-transport.js"></script>
        <script src="js/jquery.fileupload.js"></script>

        <!-- bootstrap just to have good looking page -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />

        <!-- we code these -->
        <link href="css/dropzone.css" type="text/css" rel="stylesheet" />
        <script src="js/myuploadfunction.js"></script>

        <!-- header style ignore it -->
        <link href="css/mystyle.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body>
       
        <h1 style="text-align:center">Servlet jQuery File Upload<br></h1> 
        <div id="progress" class="progress">
            <div class="bar" style="width: 0%;"></div>
        </div>
        <!-- user twitter -->
        <div id="user_twitter">
            <span>Your Twitter</span>
            <div class="input-prepend">
                <span class="add-on">@</span>
                <input class="span2" id="twitter" name="twitter" type="text" placeholder="Username">
            </div>
        </div>
        <div style="width:700px;padding:20px;S">

            <input id="fileupload" type="file" name="files[]" data-url="/AN_UploadFilesServlet" multiple>
            <input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
            <div id="dropzone" class="fade well">Drop files here</div>
            
            <h5 style="text-align:center"><i style="color:#ccc"><small>Max File Size: 2 Mb - Display last 20 files</small></i></h5>

            <table id="uploaded-files" class="table">
                <tr>
                    <th>File Name</th>
                    <th>File Size</th>
                    <th>File Type</th>
                    <th>Download</th>
                    <th>Uploaded By</th>
                </tr>
            </table>
        </div>
    </body> 
</html>