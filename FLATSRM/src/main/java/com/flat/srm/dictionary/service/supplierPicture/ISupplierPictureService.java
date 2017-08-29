package com.flat.srm.dictionary.service.supplierPicture;

import com.flat.srm.dictionary.bean.SupplierPicture;

/**
 *
 * classNmae ISupplierPictureService
 * package com.flat.srm.dictionary.service.supplierPicture
 * user jingu
 * date 2017/8/12
 * time 上午 10:16
*/
public interface ISupplierPictureService {
    /**
     * 图片保存方法
     * @param supplierPicture
     * @return
     */
    public  Integer save(SupplierPicture supplierPicture);

    /**
     * 查询
     * @param par
     * @return
     */
    public SupplierPicture find(String par);
}
