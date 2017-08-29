package com.flat.srm.dictionary;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.dictionary.bean.Supplier;
import com.flat.srm.dictionary.bean.SupplierPicture;
import com.flat.srm.dictionary.dao.supplier.ISupplierMapper;
import com.flat.srm.dictionary.dao.supplierPicture.ISupplierPictureMapper;
import com.flat.srm.dictionary.service.supplier.ISupplierService;
import org.apache.commons.fileupload.MultipartStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
        "classpath:spring/applicationContext-shiro.xml" })
/**
 * 供应商管理模块测试
 *
 * @author 金国忠  qq 274492196
 * @create 2017-08-11 下午 2:59
 */
public class SupplierText {
    @Autowired
    private ISupplierPictureMapper supplierPictureMapper;
    @Autowired
    private ISupplierService supplierService;


    @Test
    public void pictureSaveText(){
        /**
         *SupplierText方法pictureSaveText的功能描述
         * @paam []
         * @return void
         * @throws
         * @sice v1.0
         * @author jingu qq 274492196
         * 2017/8/11
        */
        SupplierPicture supplierPicture=new SupplierPicture();
        supplierPicture.setSupplierId((long) 2);
        supplierPicture.setSupplierName("浙江福莱特玻璃有限公司");
        supplierPicture.setUrl("aa/dd/ff/c/d");
        supplierPicture.setName("图片");
        supplierPicture.setNewBy("Jinguo");
        Integer id=supplierPictureMapper.save(supplierPicture);
        System.out.println("id"+id);
    }

    @Test
    public void findTest(){
        /**
         *SupplierText方法findTest的功能描述:图片查询测试
         * @paam []
         * @return void
         * @throws
         * @sice v1.0
         * @author jingu qq 274492196
         * 2017/8/15
        */
        SupplierPicture supplierPicture=supplierPictureMapper.find("1845642563_151.jpg");
        if(supplierPicture!=null ){
           System.out.println(supplierPicture.getSize());
        }
    }
    @Test
    public void findTestSupplier(){
    /**
     *SupplierText方法findTestSupplier的功能描述
     * 供应商明细查询
     * @paam []
     * @return void
     * @throws
     * @sice v1.0
     * @author jingu qq 274492196
     * 2017/8/21
    */
       /* TzParams params=new TzParams();
        List<Supplier> listSup= supplierService.find(params);
        for(Supplier supplier:listSup){
            System.out.println(supplier.getCompany());
        }*/
    }
}
