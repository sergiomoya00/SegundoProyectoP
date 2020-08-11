<%-- 
    Document   : PatientMenu
    Created on : 08-ago-2020, 21:07:06
    Author     : samoy
--%>

<%@page import="operations.HospitalizedController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <meta name="description" content=""/>
        <meta name="author" content=""/>

        <title>Menu Paciente</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

        <!-- Custom Fonts -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css"/>
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet"/>

        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.min.css" rel="stylesheet"/>

    </head>

    <body id="page-top">


        <!-- Portfolio -->
        <section class="content-section" id="portfolio">
            <div class="container text-center my-auto">
                <h1 class="mb-1">Menú del paciente</h1>
            </div>
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="http://localhost:8080/SegundoProyectoPOO/JSP/AppointmentPacient.jsp">
                            <div class="caption">
                                <div class="caption-content">
                                    <div class="h2">Ver citas</div>
                                    <p class="mb-0">Aquí puede consultar sus citas, además de solicitar o cancelar alguna si así lo desea.</p>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/portfolio-2.jpg" alt=""/>
                        </a>
                    </div>
                    
                        <div class="col-lg-6">
                            <a class="portfolio-item" href="http://localhost:8080/SegundoProyectoPOO/JSP/CreateAppointment.jsp">
                                <div class="caption">
                                    <div class="caption-content">
                                        <div class="h2">Solicitar cita</div>
                                        <p class="mb-0">Aquí puede solicitar una cita.</p>
                                    </div>
                                </div>
                                <img class="img-fluid" src="img/portfolio-2.jpg" alt=""/>
                            </a>
                        </div>
                        
                            <div class="col-lg-6">
                                <a class="portfolio-item" href="http://localhost:8080/SegundoProyectoPOO/JSP/AppointmentCancelation.jsp">
                                    <div class="caption">
                                        <div class="caption-content">
                                            <div class="h2">Cancelar cita</div>
                                            <p class="mb-0">Aquí puede cancelar sus citas.</p>
                                        </div>
                                    </div>
                                    <img class="img-fluid" src="img/portfolio-2.jpg" alt=""/>
                                </a>
                            </div>
                            <div class="col-lg-6">
                                <a class="portfolio-item" href="http://localhost:8080/SegundoProyectoPOO/JSP/DiagnosticPacient.jsp">
                                    <div class="caption">
                                        <div class="caption-content">
                                            <div class="h2">Diagnosticos asociados al paciente</div>
                                            <p class="mb-0">Listado de diagnosticos asociados al paciente</p>
                                        </div>
                                    </div>
                                    <img class="img-fluid" src="img/portfolio-2.jpg" alt=""/>
                                </a>
                            </div>
                            <div class="col-lg-6">
                                <a class="portfolio-item" href="http://localhost:8080/SegundoProyectoPOO/JSP/TreatmentPacient.jsp">
                                    <div class="caption">
                                        <div class="caption-content">
                                            <div class="h2">Tratamientos asociados al paciente</div>
                                            <p class="mb-0">Listado de tratamientos que le han medicado al paciente</p>
                                        </div>
                                    </div>
                                    <img class="img-fluid" src="img/portfolio-2.jpg" alt=""/>
                                </a>
                            </div>
                            <div class="col-lg-6">
                                <a class="portfolio-item" href="http://localhost:8080/SegundoProyectoPOO/JSP/HospitalizedPacient.jsp">
                                    <div class="caption">
                                        <div class="caption-content">
                                            <div class="h2">Ver hospitalizaciones</div>
                                            <p class="mb-0">Listado de hospitalizaciones del paciente</p>
                                        </div>
                                    </div>
                                    <img class="img-fluid" src="img/portfolio-2.jpg" alt=""/>
                                </a>
                            </div>

                        </div>
                    </div>
                    </section>



                    <!-- Scroll to Top Button-->
                    <a class="scroll-to-top rounded js-scroll-trigger" href="#page-top">
                        <i class="fas fa-angle-up"></i>
                    </a>

                    <!-- Bootstrap core JavaScript -->
                    <script src="vendor/jquery/jquery.min.js"></script>
                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                    <!-- Plugin JavaScript -->
                    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                    <!-- Custom scripts for this template -->
                    <script src="js/stylish-portfolio.min.js"></script>

                    </body>
                    </html>
