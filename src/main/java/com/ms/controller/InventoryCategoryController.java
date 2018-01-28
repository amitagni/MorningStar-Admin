package com.ms.controller;

import com.ms.bean.CategoryBean;
import com.ms.bean.InventoryCateoryBean;
import com.ms.dto.CategoryDTO;
import com.ms.entity.InventoryCateoryEntity;
import com.ms.entity.InventoryItem;
import com.ms.service.InventoryService;
import com.ms.util.MSException;
import com.ms.util.SessionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class InventoryCategoryController {
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = {"/inventorycategory"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView inventoryCategoryController(
			@ModelAttribute("inventoryCateoryBean") InventoryCateoryBean inventoryCateoryBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Inventory");
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			inventoryCateoryBean.setCategoryList(this.populateCategoryList());
			inventoryCateoryBean.setUserAction("2");
			String e = request.getParameter("err");
			if (e != null && e.equals("1")) {
				model.addAttribute("message", "Category with this name already exit");
				System.out.println("Category with this name already exits");
			}

			return new ModelAndView("inventory", "inventoryCateoryBean", inventoryCateoryBean);
		} else {
			try {
				if (inventoryCateoryBean.getUserAction().equals("1")) {
					if (!this.checkCategoryIfExists(inventoryCateoryBean.getCategoryBean().getName())) {
						this.saveCategory(inventoryCateoryBean.getCategoryBean());
					} else if (!this.checkItemWithSameCategoryExists(inventoryCateoryBean.getCategoryBean().getId(),
							inventoryCateoryBean.getItemName())) {
						return new ModelAndView("redirect:/inventorycategory.do?err=1");
					}
				} else if (inventoryCateoryBean.getUserAction().equals("2")) {
					this.inventoryService.save(this.populateInventryItem(inventoryCateoryBean));
					return new ModelAndView("redirect:/inventorycategory.do");
				}

				return new ModelAndView("redirect:/inventorycategory.do");
			} catch (Exception arg5) {
				arg5.printStackTrace();
				return new ModelAndView("inventory", "inventoryCateoryBean", inventoryCateoryBean);
			}
		}
	}

	private boolean checkItemWithSameCategoryExists(Integer id, String itemName) {
		return false;
	}

	private InventoryItem populateInventryItem(InventoryCateoryBean inventoryCateoryBean) {
		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setId(inventoryCateoryBean.getId());
		inventoryItem.setCategoryId(inventoryCateoryBean.getCategoryBean().getId());
		inventoryItem.setItemName(inventoryCateoryBean.getItemName());
		inventoryItem.setItemDes(inventoryCateoryBean.getItemDescription());
		inventoryItem.setActive((byte) 1);
		return inventoryItem;
	}

	private List<CategoryDTO> populateCategoryList() {
		List categories = this.inventoryService.findAllCateories();
		ArrayList categoryDTOList = new ArrayList();
		if (categories != null) {
			Iterator arg3 = categories.iterator();

			while (arg3.hasNext()) {
				InventoryCateoryEntity category = (InventoryCateoryEntity) arg3.next();
				CategoryDTO categoryDTO = new CategoryDTO();
				categoryDTO.setId(category.getId().intValue());
				categoryDTO.setCategoryName(category.getCategoryName());
				categoryDTOList.add(categoryDTO);
			}
		}

		return categoryDTOList;
	}

	private boolean checkCategoryIfExists(String name) {
		return this.inventoryService.findCateoryByName(name) != null;
	}

	private Integer saveCategory(CategoryBean categoryBean) throws MSException {
		InventoryCateoryEntity category = new InventoryCateoryEntity();
		category.setCategoryName(categoryBean.getName());
		category.setCategoryDescription(categoryBean.getDescription());
		category.setActive(Byte.valueOf((byte) 1));
		this.inventoryService.save(category);
		return category.getId();
	}
}