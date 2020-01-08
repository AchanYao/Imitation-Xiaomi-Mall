package com.achan.xiaomi_store.service.main;

import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import com.achan.xiaomi_store.model.jpa.entity.ItemTypeEntity;
import com.achan.xiaomi_store.service.exception.IncompleteEntityException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
public class TestItemService {

    @Autowired
    private ItemService itemService;

    private static ItemTypeEntity[] itemTypeEntities = new ItemTypeEntity[]{
            new ItemTypeEntity().setId(1).setName("xm mobile").setNameZh("小米手机"),
            new ItemTypeEntity().setId(2).setName("appliances").setNameZh("家电"),
            new ItemTypeEntity().setId(3).setName("hm mobile").setNameZh("红米手机"),
            new ItemTypeEntity().setId(5).setName("tv").setNameZh("电视"),
            new ItemTypeEntity().setId(6).setName("notebook").setNameZh("笔记本"),
            new ItemTypeEntity().setId(7).setName("router").setNameZh("路由器"),
            new ItemTypeEntity().setId(8).setName("IntelligentHardware").setNameZh("智能硬件"),
            new ItemTypeEntity().setId(9).setName("unknown").setNameZh("未知"),
    };

    @Test
    public void initXmMobileItems() throws IncompleteEntityException {
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[0]).setTypeId(itemTypeEntities[0].getId()).setProductName("小米CC9 Pro").setPrice(2599.0)
                .setDescription("120Hz高帧率流速屏 / 索尼6400万前后六摄 / 6.67''小孔径全面屏 / 最高可选8GB+256GB大存储 / 高通骁龙730G处理器 / 3D四曲面玻璃机身 / 4500mAh+27W快充 / 多功能NFC")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[0]).setTypeId(itemTypeEntities[0].getId()).setProductName("小米9 Pro 5G").setPrice(3699.0)
                .setDescription("5G双卡全网通超高速网络 / 骁龙855Plus旗舰处理器 / 40W有线闪充+30W无线闪充+10W无线反充，4000mAh长续航 / 4800万全焦段三摄 / 超振感横向线性马达 / VC液冷散热 / 高色准三星AMOLED屏幕 / 多功能NFC / 赠送小米云服务1TB云存储")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/41c566d825a3ae3b5751a78d4c7cffdb.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[0]).setTypeId(itemTypeEntities[0].getId()).setProductName("小米CC9").setPrice(1699.0)
                .setDescription("「火爆热卖中，6GB+128GB购机赠10000mAh充电宝」前置3200万自拍 / 索尼4800万超广角三摄 / 多色炫彩轻薄机身 / 6.39英寸三星 AMOLED水滴屏 /4030mAh大电量 / 骁龙710处理器 / 屏幕指纹 / NFC功能 / 红外遥控功能 / Game Turbo2.0游戏加速")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f515ab05232ed14ccd78ec67e024495a.png?thumb=1&w=200&h=138")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[0]).setTypeId(itemTypeEntities[0].getId()).setProductName("小米CC9e").setPrice(1099.0)
                .setDescription("前置3200万自拍 / 索尼4800万超广角三摄 / 4030mAh大电量 / 3D全曲面玻璃机身，浪漫满分的全新配色 / 6.088英寸三星 AMOLED水滴屏 /第七代屏幕指纹 / 首发骁龙665处理器 / 全新Mimoji萌拍 / 红外遥控功能")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/df9b3e7a562e02a33eb069b3f0119815.png?thumb=1&w=200&h=138")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[0]).setTypeId(itemTypeEntities[0].getId()).setProductName("小米CC9 美图定制版").setPrice(1999.0)
                .setDescription("100%美图相机，前置3200万，自拍美得更自然 / 索尼4800万超广角三摄，拍风景、建筑、多人合影，画面更震撼 / 美图经典人像，不修图也好看 / AI弱光人像，暗光环境也能拍出水光肌 / 全身美型，变美不变形 / 4030mAh大电量，足够尽兴玩一天 / 美图定制仙女配色、轻薄机身 / 6.39英寸三星 AMOLED水滴屏 / 骁龙710处理器 / 第七代屏幕指纹解锁 / 支持NFC和红外遥控")
                .setStockQuantity(500).setPicUrl("https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b02f50c9dd2e01c139a06a12502755ef.png?thumb=1&w=200&h=138")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[0]).setTypeId(itemTypeEntities[0].getId()).setProductName("小米MIX 3").setPrice(2599.0)
                .setDescription("DxOMark拍照108分 / 磁动力滑盖全面屏 / 四曲面陶瓷机身 / 骁龙845旗舰处理器 / 包装盒内附赠10W无线充电器")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/3b5e5829fdf92d54c167f4681531b535.png?thumb=1&w=200&h=138")
        );
    }

    @Test
    public void initHmMobileItems() throws IncompleteEntityException {
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[2]).setTypeId(itemTypeEntities[2].getId()).setProductName("Redmi K30").setPrice(1699.0)
                .setDescription("「购机赠耳机；享小米/花呗6期免息；+1元得50G云空间月卡；延保享7折优惠」120Hz高帧率流速屏 / 索尼6400万前后六摄 / 6.67''小孔径全面屏 / 最高可选8GB+256GB大存储 / 高通骁龙730G处理器 / 3D四曲面玻璃机身 / 4500mAh+27W快充 / 多功能NFC")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/cff2977b8aab1e43b94b2f00083f4ae1.jpg?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[2]).setTypeId(itemTypeEntities[2].getId()).setProductName("Redmi K30 5G").setPrice(2599.0)
                .setDescription("「0元预约中，1月7日首卖，敬请期待」双模5G / 三路并发 / 高通骁龙765G / 7nm 5G低功耗处理器 / 120Hz高帧率流速屏 / 6.67''小孔径全面屏 / 索尼6400万前后六摄 / 最高可选8GB+256GB大存储 / 4500mAh+30W快充 / 3D四曲面玻璃机身 / 多功能NFC")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/742a328bdaa242aea89ec2a9c8661013.jpg?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[2]).setTypeId(itemTypeEntities[2].getId()).setProductName("Redmi 8A").setPrice(599.0)
                .setDescription("「3GB+32GB直降100元，到手价仅599元，加1元得50G云空间月卡」5000mAh大电量 / 最高可选4GB+64GB版本 / 支持18W快充 / Type-C充电接口 / 6.22水滴全面屏 / AI人脸解锁 / 骁龙八核处理器 / 超大音量 / 支持无线FM收音机")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/398311b2e6f47ac324ba0421a0ac1b80.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[2]).setTypeId(itemTypeEntities[2].getId()).setProductName("Redmi Note 8").setPrice(899.0)
                .setDescription("「火爆热卖中，4GB+64GB首次闪降100元，到手价899元」4800万全场景四摄 / 前置1300万美颜相机 / 骁龙665处理器 / 4000mAh超长续航 / 标配18W快充 / 超线性扬声器 / 90%高屏占比 / 康宁大猩猩保护玻璃 / 6.3英寸水滴全面屏")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/dacd6a3d8440b7a038e9778702bd6db6.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[2]).setTypeId(itemTypeEntities[2].getId()).setProductName("Redmi K20 Pro 尊享版").setPrice(2799.0)
                .setDescription("「12GB+512GB到手价仅2799元。最高享6期免息，每期低至467元。加1元得50G云空间月卡；延保享7折优惠」高通骁龙855 Plus处理器 / 最高可选12GB+512GB大内存 / 索尼4800万超广角三摄 / 前置2000万升降式相机 / 6.39\"AMOLED极界全面屏 / 3D四曲面玻璃机身 / 4000mAh超长续航 / 标配27W充电器 / 8层石墨立体散热 / 第七代屏下指纹解锁 / 多功能NFC / 双频GPS导航")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c1937ecb7e9b8e1aee11d6936e19d53c.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity()
                .setItemTypeEntity(itemTypeEntities[2]).setTypeId(itemTypeEntities[2].getId()).setProductName("Redmi Note 8 Pro").setPrice(1199.0)
                .setDescription("「火爆热卖中，6GB+64GB闪降100元，到手价1199元起，+30元得黑鲨游戏手柄套装，延保享7折优惠」6400万旗舰级全场景四摄 / 前置2000万 AI美颜相机 / G90T专业游戏芯片，液冷散热 / 6.53英寸水滴全面屏 / 4500mAh大电量 / 标配18W快充 / 康宁大猩猩保护玻璃 / 多功能NFC / 红外遥控功能 / Game Turbo2.0游戏加速")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/8ee0af37bbd2f5a83c799e87dd791037.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
    }

    @Test
    public void addElseItem() throws IncompleteEntityException {
        itemService.saveItem(new ItemEntity().setItemTypeEntity(itemTypeEntities[3]).setTypeId(itemTypeEntities[3].getId())
                .setProductName("Redmi 红米电视 70英寸 R70A")
                .setPrice(2999.0)
                .setDescription("Redmi 红米电视 70英寸 R70A")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6917267948c54c647d2009a98637aac6.jpg?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity().setItemTypeEntity(itemTypeEntities[4]).setTypeId(itemTypeEntities[4].getId())
                .setProductName("RedmiBook 13")
                .setPrice(4499.0)
                .setDescription("RedmiBook 13")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6abc701fb3cf48f2c7a3fd5ef053529a.jpg?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity().setItemTypeEntity(itemTypeEntities[1]).setTypeId(itemTypeEntities[1].getId())
                .setProductName("米家互联网空调C1")
                .setPrice(2599.0)
                .setDescription("米家互联网空调C1")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/03dc85cd792904ddc8027b2d781beed8.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity().setItemTypeEntity(itemTypeEntities[5]).setTypeId(itemTypeEntities[5].getId())
                .setProductName("Redmi路由器AC2100")
                .setPrice(169.0)
                .setDescription("Redmi路由器AC2100")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/aa1e0a4860cf40d34e1192d86691c82c.png?thumb=1&w=200&h=138&f=webp&q=90")
        );
        itemService.saveItem(new ItemEntity().setItemTypeEntity(itemTypeEntities[6]).setTypeId(itemTypeEntities[6].getId())
                .setProductName("小米米家智能摄像机云台版")
                .setPrice(169.0)
                .setDescription("小米米家智能摄像机云台版")
                .setStockQuantity(500)
                .setPicUrl("https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/2a500be4264c692899b25d86c16403f7.jpg?thumb=1&w=200&h=138")
        );
    }

    @Test
    public void testFindAll() {
        itemService.findAllItem().forEach(System.out::println);
    }
}
