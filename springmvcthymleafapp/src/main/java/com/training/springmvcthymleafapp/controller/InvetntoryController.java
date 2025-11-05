package com.training.springmvcthymleafapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.springmvcthymleafapp.model.Item;

@Controller
public class InvetntoryController {

	private List<Item> itemList = new ArrayList<>();
	
	private void initList() {
		itemList.add(new Item(1, "COFFE", 40));
		itemList.add(new Item(2, "TEA", 30));
		itemList.add(new Item(3, "IDLY", 50));
		itemList.add(new Item(4, "LUNCH", 100));
	}
	
	@RequestMapping("/list")
	public ModelAndView itemList() {
		if(itemList.isEmpty()) {
			initList();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("items", itemList);
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping("/addform")
	public String addItem(Model model) {
		if(itemList.isEmpty()) {
			initList();
		}
		model.addAttribute("item",new Item());
		return "additem";
	}
	
	private Set updateEid() {
		return  itemList.stream().map(Item::getId).collect(Collectors.toSet());
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute("item") Item model,BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.addObject("items", itemList);
		Item exitingItem = itemList.stream().filter(item->item.getId() == model.getId())
				.findFirst().orElse(null);
		
		int expectednum = 1;
		
		if(exitingItem==null) {
			Set<Integer> iid = updateEid();
			
			int epectedId = itemList.size();
			for (int i=0;i<iid.size();i++) {
				if(!iid.contains(i+1)) {
					expectednum = i+1;
				};
			}
			
			itemList.add(new Item(expectednum,model.getItemName(),model.getPrice()));
		}
		else {
			exitingItem.setItemName(model.getItemName());
			exitingItem.setPrice(model.getPrice());
		}
		return mav;
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView update(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("additem");
		mav.addObject("item", itemList.stream().filter(item->item.getId() == id).findFirst());
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		
		Item exitingitem =  itemList.stream().filter(item->item.getId() == id).findFirst().orElse(null);
		
		if(exitingitem!=null) {
		itemList.remove(exitingitem);
		updateEid();
		}
		
		mav.addObject("items", itemList);
		return mav;
	}
	
	
	
}
