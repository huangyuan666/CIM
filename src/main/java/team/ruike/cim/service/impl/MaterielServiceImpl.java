package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.MaterielDao;
import team.ruike.cim.dao.MaterielTypeLevelADao;
import team.ruike.cim.dao.MaterielTypeLevelBDao;
import team.ruike.cim.dao.MaterielUnitDao;
import team.ruike.cim.pojo.Materiel;
import team.ruike.cim.pojo.MaterielTypeLevelA;
import team.ruike.cim.pojo.MaterielTypeLevelB;
import team.ruike.cim.pojo.MaterielUnit;
import team.ruike.cim.service.MaterielService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;
/**
 * 物料管理业务类
 * @author 张振国
 * @version 1.0
 * @see #getMaterielList(Materiel, Pager)
 * @see #getMaterielTypeLevelB()
 * @see #getMaterielTypeLevelA()
 * @see #getMaterielUnit()
 */
@Service("materielService")
public class MaterielServiceImpl implements MaterielService {
    @Resource
    private MaterielDao materielDao;
    @Resource
    private MaterielTypeLevelADao materielTypeLevelADao;
    @Resource
    private MaterielTypeLevelBDao materielTypeLevelBDao;
    @Resource
    private MaterielUnitDao materielUnitDao;
    /**
     * 获取物料列表
     * @param materiel 物料对象（查询条件）
     * @param pager 分页辅助类对象
     */
    public void getMaterielList(Materiel materiel, Pager<Materiel> pager) {
        //查询总条数
        pager.setTotalRecord(materielDao.selectCount(materiel));
        //查询物料列表
        List<Materiel> materielList = materielDao.select(materiel, (pager.getCurrentPage()- 1) * pager.getPageSize(), pager.getPageSize());
        //放入分页辅助类
        pager.setList(materielList);
    }

    /**
     * 新增物料
     * @param materiel 物料对象
     * @return 是否成功
     */
    public boolean addMaterielList(Materiel materiel) {
        int i = materielDao.add(materiel);
        return i==1;
    }

    /**
     * 获取所有物料一级分类集合
     * @return 所有物料一级分类集合
     */
    public List<MaterielTypeLevelA> getMaterielTypeLevelA() {
        return materielTypeLevelADao.select(new MaterielTypeLevelA(),0,99);
    }
    /**
     * 获取所有物料二级分类集合
     * @return 所有物料二级分类集合
     */
    public List<MaterielTypeLevelB> getMaterielTypeLevelB() {
        return materielTypeLevelBDao.select(new MaterielTypeLevelB(), 0, 99);
    }
    /**
     * 获取所有物料单位集合
     * @return 所有单位集合
     */
    public List<MaterielUnit> getMaterielUnit() {
        return materielUnitDao.select(new MaterielUnit(), 0, 99);
    }
}