<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Product Management</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}

h6{
	text-align: center;
	width : 250px;
}

footer{
	text-align: center;
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

th {
  border: 1px solid #dddddd;
  text-align: center;
  padding: 8px;
  color: white;
  
}

td {
  border: 1px solid #dddddd;
  text-align: left;
  text-align: center;
  padding: 8px;
  color: black;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

</style>

<body class="w3-blue-gray">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:5">
  
  <img src="https://thumbs.dreamstime.com/b/hand-holding-plant-green-fields-backdrop-sprout-logo-concept-agriculture-natural-food-products-fertilizers-vector-206319849.jpg" class="w3-circle w3-left" style="width:40px">
  <span class="w3-bar-item w3-left">Staff Mercu Wahdah</span>
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <a href="login.jsp" class="w3-bar-item w3-right">LogOut</a>
</div>
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-black w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <hr>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb7bBCY-PazEulrhpxKxEKIaNpcLO85bUHHg&usqp=CAU" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>Staff</strong></span><br>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="Dashboard.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-home fa-fw"></i>  Home</a>
    <a href="manageProduct.jsp" class="w3-bar-item w3-button w3-padding" ><i class="fa fa-table fa-fw" ></i>  Product Management</a>
    <a href="manageStaff.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  Staff Management</a>
    <a href="manageSupplier.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-address-card fa-fw"></i>  Supplier Management</a>
  	<a href="manageRequest.jsp" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-diamond fa-fw"></i>  Request Product</a>
	</div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> My Dashboard</b></h5>
  </header>
  <br>
            
    <div class="row">
        <div class="col-lg-12 margin-tb">
            <div class="w3-pull-right">
            	<a class="w3-button w3-blue fa fa-arrow-left" href="manageRequest.jsp"> Back</a>
        	</div>
            <div class="w3-pull-left">
                <h2 class="headertekst" align="center">Request Product Form</h2>
            </div>
        </div>
    </div>
	<br>
	<div class="col-xs-12 col-sm-12 col-md-12 w3-center">
            <div class="form-group row">
                <strong class="col-md-4 col-form-label text-md-right">Supplier ID </strong>
                <input type="text" name="supplier_id" class="form-control col-md-6" placeholder="Supplier ID">
            </div>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-12 w3-center">
            <div class="form-group row">
                <strong class="col-md-4 col-form-label text-md-right">Supplier Name &nbsp;</strong>
                <input type="text" name="supplier_name" class="form-control col-md-6" placeholder="Supplier Name">
                <button type="submit"><i class="w3-center fa fa-search"></i></button>
            </div>
        </div>
        <br>
    <table>
        <tr>
            <th>No.</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price Per unit (MYR)</th>
            <th width="250px" align="center">Quantity</th>
            <th width="250px" align="center">Price (MYR)</th>
            
        </tr>
       
        <tr>
        	<td>1.</td>
            <td>00000</td>
            <td>ubat Kutu</td>        
            <td>35.00</td>
            <td><input type="number" name="quantity" class="form-control col-md-6" placeholder="0"></td>   
            <td>3,500.00</td>
        </tr>
    </table>
    <br><br>
    
  
    <div class="col-xs-12 col-sm-12 col-md-12 w3-right">
    		<h6 class="form-group row w3-container w3-white">
                <strong class="col-md-4 col-form-label text-md-right">Gross Price : RM </strong>
                <a class="form-control col-md-4 ">3,500.00</a>
            </h6>
            <h6 class="form-group row w3-container w3-white">
                <strong class="col-md-4 col-form-label text-md-right">SST 6% &nbsp;&nbsp;&nbsp;: RM </strong>
                <a class="form-control col-md-4  ">210.00</a>
            </h6>
            <h6 class="form-group row w3-container w3-white">
                <strong class="col-md-4 col-form-label text-md-right">Total Price : RM </strong>
                <a class="form-control col-md-4 ">3,710.00</a>
            </h6>
            <br>
            <h6>
            <a class="w3-btn w3-red" href="manageRequest.jsp"> Cancel</a>
            <button type="submit" class="w3-btn w3-blue">Submit</button>
            </h6>

    
                
        </div><br><br> 
     <br><br><br><br><br>
<br><br><br><br><br>
 <!-- Footer -->
  <footer class="w3-container w3-padding-16 w3-blue-gray">
    <strong>Copyright &copy; 2014-2021 <a href="http://localhost:9080/InventoryManagementv1/dashboard.jsp#">MercuWahdah.com.my</a></strong>
        All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.1.0
    </div>
  </footer>

  <!-- End page content -->
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>

</body>
</html>