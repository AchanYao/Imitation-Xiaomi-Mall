<template>
  <div class="site-topbar">
    <div class="container">
        <div class="topbar-nav">
            <a rel="nofollow" href="//www.mi.com/index.html">小米商城</a><span class="sep">|</span><a rel="nofollow" href="https://www.miui.com/" target="_blank">MIUI</a><span class="sep">|</span><a rel="nofollow" href="https://iot.mi.com/index.html">IoT</a><span class="sep">|</span><a rel="nofollow" href="https://i.mi.com/" target="_blank">云服务</a><span class="sep">|</span><a rel="nofollow" href="https://jr.mi.com?from=micom" target="_blank">金融</a><span class="sep">|</span><a rel="nofollow" href="https://youpin.mi.com/" target="_blank">有品</a><span class="sep">|</span><a rel="nofollow" href="https://xiaoai.mi.com/" target="_blank">小爱开放平台</a><span class="sep">|</span><a rel="nofollow" href="https://qiye.mi.com/" target="_blank">企业团购</a><span class="sep">|</span><a rel="nofollow" href="https://www.mi.com/aptitude/list/?id=41" target="_blank">资质证照</a><span class="sep">|</span><a rel="nofollow" href="https://www.mi.com/aptitude/list/" target="_blank">协议规则</a><span class="sep">|</span><a rel="nofollow" href="//www.mi.com/appdownload/" target="_blank" id="J_downloadapp" style="position: relative;">下载app<span class="box" style="width:124px;position: absolute; top: 40px;left: 50%;padding: 18px 0 14px;background: #fff;margin-left: -55px; box-shadow: #aaa 0px 1px 5px;display:none;"><em style="width:0;height:0;border-width:0 10px 10px;border-style:solid;border-color:transparent transparent #fff;position:absolute;top:-10px;left:50px;"></em><img src="//i1.mifile.cn/f/i/17/appdownload/download.png?1" alt="小米商城" width="90" height="90" style="display:block;margin: 0 auto;"><span style="display:block;text-align: center;font-size:14px;color:#333;line-height:1;margin-top:14px;">小米商城APP</span></span></a>
        </div>
        <div class="topbar-cart" id="J_miniCartTrigger">
            <a rel="nofollow" class="cart-mini" id="J_miniCartBtn" href="//static.mi.com/cart/"><i class="iconfont"></i>购物车<span class="cart-mini-num J_cartNum">（0）</span></a>
            <div class="cart-menu" id="J_miniCartMenu">
                <div class="loading"><div class="loader"></div></div>
            </div>
        </div>
        <div class="topbar-info" id="J_userInfo">
            <a rel="nofollow" class="link" href="//order.mi.com/site/login" data-agreement="true" data-login="true">登录</a><span class="sep">|</span><a rel="nofollow" class="link" href="https://account.xiaomi.com/pass/register" data-agreement="true" data-register="true">注册</a>        </div>
    </div>
</div>
</template>

<script>
export default {
    name: "SiteTopBar"
}
</script>

<style>
.site-topbar {
    position: relative;
    z-index: 30;
    height: 40px;
    font-size: 12px;
    color: #b0b0b0;
    background: #333;
}

.site-topbar .topbar-nav {
    float: left;
    height: 40px;
    line-height: 40px;
}

.site-topbar .topbar-cart {
    width: 120px;
    margin-left: 15px;
}

.site-topbar .topbar-info {
    line-height: 40px;
}

.site-topbar .topbar-cart, .site-topbar .topbar-info {
    position: relative;
    float: right;
    _display: inline;
    height: 40px;
}

.site-topbar a {
    color: #b0b0b0;
    line-height: 40px;
    display: inline-block;
    *zoom: 1;
    *display: inline;
}

.site-topbar .cart-mini {
    position: relative;
    z-index: 32;
    display: block;
    height: 40px;
    line-height: 40px;
    text-align: center;
    color: #b0b0b0;
    background: #424242;
}

.site-topbar .topbar-info .link {
    padding: 0 5px;
    text-align: center;
}

.site-topbar .sep {
    margin: 0 .5em;
    color: #424242;
}
</style>