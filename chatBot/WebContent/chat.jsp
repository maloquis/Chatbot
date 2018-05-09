<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="pacote.Cliente"%>
<%@page import="pacote.ChatB"%>
<%@ page import="pacote.Conversa"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; harset=UTF-8">
<title>ChatBot</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body background="img/books.jpg">


	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom">
	<div class="container">
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="home.html"><a href="#menu-toggle"
				class="btn btn-secondary p1" id="menu-toggle">Cartório</a></a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="page-scroll"><a href="index.html">Cadastrar-se</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<h6>
		
		id :=
		${cliente.id}<br> Nome: =
		${cliente.nome}<br> email: =
		${cliente.email}<br>
	</h6>
	<center>
		<font color="white"><h3>
				Bem-Vindo ao Chat Boot<br>
				${cliente.nome}<br></font>

		</h3>
	</center>
	<hr>



	<form name="chatBController.do" action="chatBController.do"
		method="post">

		<div class="row">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<form name="sentMessage" id="contactForm" novalidate>
					
					<center><font color="white"><bold><h3>Qual sua duvida ?</h3></bold> </font></center>
						
					
						<div class="row control-group col-lg-12">
						
					
								  <div class="col-lg-11">

									<font color="white"> </font> 
								<input type="text" id="pergunta"
									class="form-control" placeholder="Faça sua pergunta"
									name="pergunta">

								  </div>							
								  <div class="col-lg-1">
								  
								  <button type="submit" value="Enviar" name="acao"
								class="btn btn-success btn-lg" style="height:38px">Enviar</button>
								  
								  </div>
								  
						</div>
						<br><br>
						
						<center><font color="white"><bold><h3>Conversa ChatBot</h3></bold> </font></center>
						
						
												
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<textarea class="form-control" name="txtMessage" rows="20"
									cols="70">
									
									
         		
         		<c:forEach var="conversa" items="${Conversa conversa}">     
         		   
         		${cliente.nome} + ":" + ${conversa.getPergunta}  
         		  
         		${cliente.fone}           		       		
         		${cliente.email} 
         		</c:forEach>  
         		
         		
         		
         		out.println(" ");
         		String MENSSAGEM_DE_ENTRADA = "Bot:  Ola, " + ${cliente.nome} + "! Qual a sua duvida? "
         		ChatB chat = (ChatB) session.getAttribute("chat");
         		out.println(MENSSAGEM_DE_ENTRADA);
         		for (Conversa conversa : chat.getConversas()) {
         			out.println(${cliente.nome} + ": " + conversa.getPergunta());
         			out.println("Bot: " + ${conversa.resposta} );
         		}
         	
          
									
									
         </textarea>
         <button type="submit" class="btn btn-primary" name="acao" value="Sim">N&atilde;o</button>
								<button type="button" onclick="carrega()" class="btn btn-default" data-dismiss="modal"><a href="www.outlook.com">Sim</a></button>

         
							</div>
						</div>
						
					</form>
				</div>
			</div>
		</div>
		
		
		
		
		


		</section>

		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>