package com.asrtu.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asrtu.dao.ProdSubGroupDao;
import com.asrtu.model.ItemGroup;
import com.asrtu.model.ItemPgTab;
import com.asrtu.model.ProdSubGroup;

/**
 * @author ##
 *
 */

@Service("prodSubGroupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProdSubGroupServiceImpl implements ProdSubGroupService {

	@Autowired
	private ProdSubGroupDao prodSubGroupDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProdSubGroup(ProdSubGroup subGroup) {
		prodSubGroupDao.addProdSubGroup(subGroup);
		
	}
	

	@Override
	public List<ProdSubGroup> listProdSubGroup() {
		
		return prodSubGroupDao.listProdSubGroup();
	}

	@Override
	public ProdSubGroup getProdSubGroup(int id) {
		
		return prodSubGroupDao.getProdSubGroup(id);
	}

	@Override
	public void deleteProdSubGroup(ProdSubGroup subGroup) {
		
		prodSubGroupDao.deleteProdSubGroup(subGroup);
		
	}


	@Override
	public List<ItemPgTab> listItemGroup() {
		// TODO Auto-generated method stub
		return prodSubGroupDao.listItemGroup();
	}


}
