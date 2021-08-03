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
<h1><b>CLEAR</b></h1>
<h1><b>${count}</b></h1>
<a href="/ui/init"><button>New game</button></a>
<#--<a href="/ui/getcard"><button>Get card</button></a>-->
<a href="/ui/refill"><button>Refill</button></a>
</body>
</html>