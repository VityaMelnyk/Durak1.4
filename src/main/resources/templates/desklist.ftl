<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/styles.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/styles.css'/>"/>
    <title>Title</title>
</head>
<body bgcolor="green">
<h1><b>DESK LIST</b></h1>
<h1><b>${count}</b></h1>
<a href="/ui/init">
    <button>New game</button>
</a>
<#--<a href="/ui/getcard"><button>Get card</button></a>-->
<a href="/ui/refill" style="background-image: url(/static/img.background/game-over.jpg)">
    <button>Refill</button>
</a>
<div style="border: solid 3px black">
    <ul class="allCard">
        <#list listComp as card>
            <li><img src="${card.img}" alt="card"></li>
        </#list>
    </ul>
    <div>

        <div style="border: solid 3px black">
        </div>
        <div style="border: solid 3px black">
        </div>

        <div style="border: solid 3px black">
            <ul class="allCard">
                <#list list as card>
                    <li>
                        <a href="/ui/pick/${card.suit}/${card.nominal}">
                            <img src="${card.img}" alt="card">
                        </a>
                    </li>
                </#list>
            </ul>
            <#--    <a href="/web/cards/pick">
                    <img src="/img/tittle.png" alt="1111">
                </a>-->
        </div>
</body>
</html>