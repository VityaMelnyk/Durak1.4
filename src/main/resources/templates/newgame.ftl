<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/styles.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/styles.css'/>"/>
    <title>Title</title>
</head>
<body bgcolor="green">
<h1><b>New game</b></h1>
<h1><b>${count}</b></h1>
<img src="/img/fulldeck/back.png" alt="card">
<a href="/ui/init"><button>Init cards</button></a>
<#--<a href="/ui/getcard"><button>Get card</button></a>-->
<a href="/ui/refill"><button>Refill cards</button></a>
</body>
</html>