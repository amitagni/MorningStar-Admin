package com.ms.service;

import com.ms.dao.CategoryDao;
import com.ms.dao.InventoryItemDao;
import com.ms.entity.InventoryCateoryEntity;
import com.ms.entity.InventoryItem;
import com.ms.util.MSException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {
	@Autowired
	private InventoryItemDao inventoryItemDao;
	@Autowired
	private CategoryDao categoryDao;

	@Transactional(rollbackFor = {Exception.class})
	public InventoryItem save(InventoryItem inventryItem) throws MSException {
		if (inventryItem.getId() != null && inventryItem.getId().intValue() > 0) {
			inventryItem = (InventoryItem) this.inventoryItemDao.merge(inventryItem);
		} else {
			this.inventoryItemDao.persist(inventryItem);
		}

		return inventryItem;
	}

	@Transactional(rollbackFor = {Exception.class})
	public InventoryCateoryEntity save(InventoryCateoryEntity category) throws MSException {
		if (category.getId() != null && category.getId().intValue() > 0) {
			category = (InventoryCateoryEntity) this.categoryDao.merge(category);
		} else {
			this.categoryDao.persist(category);
		}

		return category;
	}

	@Transactional(rollbackFor = {Exception.class})
	public boolean deleteInventoryItem(Integer id) {
		InventoryItem inventoryItem = (InventoryItem) this.inventoryItemDao.findById(id, InventoryItem.class);
		inventoryItem.setActive((byte) 0);
		this.inventoryItemDao.merge(inventoryItem);
		return true;
	}

	public List<InventoryCateoryEntity> findCateoriesByName(String categoryName) {
		return this.categoryDao.findCateoriesByName(categoryName);
	}

	public InventoryCateoryEntity findCateoryByName(String categoryName) {
		return this.categoryDao.findCateoryByName(categoryName);
	}

	public List<InventoryCateoryEntity> findAllCateories() {
		try {
			return this.categoryDao.findAll(InventoryCateoryEntity.class);
		} catch (MSException arg1) {
			arg1.printStackTrace();
			return null;
		}
	}

	public InventoryCateoryEntity findCategoryById(Integer id) {
		return (InventoryCateoryEntity) this.categoryDao.findById(id, InventoryCateoryEntity.class);
	}
}