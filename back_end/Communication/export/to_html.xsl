<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="2.0">
    
    <xsl:template match="/">
        <html>
            <head>                
                <meta charset="utf-8"></meta>
                <meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
                <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
                <meta name="description" content=""></meta>
                <meta name="author" content=""></meta>                                    
                <title>Berlioz Manager</title>                                    
                <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"></link>           
                <link href="https://dl.dropboxusercontent.com/u/15091626/multiple-select.css" rel="stylesheet"></link>
                <link href="https://dl.dropboxusercontent.com/u/15091626/font-awesome.min.css" rel="stylesheet" type="text/css"></link>
            </head>
            
            <body background="../../../../front_end/img/intro-bg.jpg">
                <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="http://localhost/BerliozManager/front_end/index.html">Berlioz Manager</a>
                        </div>
                    </div>
                </nav>
                <header> <hr><br></br></hr></header>                
                
                <div class="container">                    
                    <div class="row">
                        <div class="col-lg-12">                               
                            <xsl:apply-templates/>                           
                        </div>
                    </div>
                    
                    <script src="https://dl.dropboxusercontent.com/u/15091626/jquery.js"></script>
                    <script src="https://dl.dropboxusercontent.com/u/15091626/bootstrap.js"></script>
                </div>   
            </body>
        </html>    
    </xsl:template>
    
    <xsl:template match="audition/metadata">
        <div class="col-lg-12" align="center">
            <hr></hr>
            <div class="panel panel-primary">
                
                <div class="panel-heading">                    
                    <b><xsl:apply-templates select="title"/></b>                    
                </div>
                <div class="panel-body">
                    <p><b>Subtitle:</b> <xsl:apply-templates select="subtitle"/></p>
                    <p><b>Subject: </b><xsl:apply-templates select="subject"/></p>
                    <p><b>Place: </b><xsl:apply-templates select="place"/></p>
                    <p><b>Organizer: </b><xsl:apply-templates select="organizer"/></p>
                    <p><b>Date: </b><xsl:apply-templates select="date"/></p>
                    <p><b>Time: </b><xsl:apply-templates select="time"/></p>
                    <p><b>Duration: </b><xsl:apply-templates select="duration"/></p>
                </div>
                
            </div>
        </div> 
        <div class="col-lg-12">
            <h1 class="page-header">
                List of Perfomances
            </h1>
        </div>
    </xsl:template>
    <xsl:template match="audition/performances/performance">
        <div class="col-md-6">
            <div class="panel panel-primary">
                
                <div class="panel-heading" align="center">
                    <b><xsl:apply-templates select="group"/></b>
                    <b><xsl:apply-templates select="performers/performer"/></b>
                </div>
                
                <div class="panel-body">
                    <h4><b>Leaders: </b><xsl:apply-templates select="leaders/leader"/></h4>
                    <h4><b>Pieces list:</b><xsl:apply-templates select="plays/play"/></h4>
                </div>
            </div>
        </div>
    </xsl:template>    
    
    
    <xsl:template match="audition/performances/performance/leaders/leader">
        
            <xsl:apply-templates/><br></br>
         
    </xsl:template>
    <xsl:template match="audition/performances/performance/group">
 
        <xsl:apply-templates/><br></br>
        
    </xsl:template>
    
    <xsl:template match="audition/performances/performance/performers/performer">
            
            <xsl:apply-templates/><br></br>
        
    </xsl:template>
    
    <xsl:template match="audition/performances/performance/plays/play">
        <ul>
            <xsl:apply-templates/>
        </ul>
    </xsl:template>       
    
    
    
    
    
</xsl:stylesheet>