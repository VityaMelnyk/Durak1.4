<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/styles.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/styles.css'/>"/>
    <title>Durak</title>
</head>
<body style="/*background-image: url(img.background/playing-cards.jpg)*/">
<h1 align="center">
    <a href="/ui/init"><button style="color: black;
          background-color: greenyellow;
          font-size: 15px;
          opacity: 0.7;
          transition: 0.5s;
          transition-duration: 0.5s;
          border-radius: 4px;">New game</button></a>

    <a href="/ui/trash"><button style="
          color: #000;
          background: dodgerblue;
          opacity: 0.7;
          font-size: 15px;
          transition: 0.5s;
          transition-duration: 0.5s;
          border-radius: 4px;">Trash</button></a>
    <p><#if message>Player</#if><#if !message>Comp</#if> turn</p>
</h1>
<div class="container"style="
    align-items: center;
    width: 80%;
    height: 80%;">
    <div class="deck-container">
        <p>${count}</p>
        <#if (count>1)><img src="/img/fulldeck/back.png" alt="card"></#if>
        <#if (count>0)><img src="${trump.img}" alt="card"></#if>
    </div>
    <div class="cards-container">
        <div>
            <ul>
                <#list listComp as card>
                    <li>
                        <img src="${card.img}" alt="card"><#-- ${card.value}-->
                    </li>
                </#list>
            </ul>
        </div>
        <div>
            <ul>
                <#list compMove as card>
                    <li>
                        <img src="${card.img}" alt="card">
                    </li>
                </#list>
            </ul>
        </div>
        <div>
            <ul>
                <#list myMove as card>
                    <li>
                        <img src="${card.img}" alt="card">
                    </li>
                </#list>
            </ul>
        </div>
        <div>
            <ul>
                <#list list as card>
                    <li>
                        <a href="/ui/pick/${card.suit}/${card.nominal}">
                            <img src="${card.img}" alt="card">
                        </a>
                        <#--${card.value}-->
                    </li>
                </#list>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
