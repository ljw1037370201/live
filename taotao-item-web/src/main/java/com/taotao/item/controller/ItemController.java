package com.taotao.item.controller;

import com.taotao.pojo.Item;
import com.taotao.pojo.Tbitem;
import com.taotao.pojo.Tbitemdesc;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    public String showItemInfo(@PathVariable long itemId,Model model){
        Tbitem tbitem = itemService.getItemById(itemId);
        Item item = new Item(tbitem);
        Tbitemdesc tbitemdesc = itemService.getTbitemdescById(itemId);
        model.addAttribute("item",item);
        model.addAttribute("tbitemdesc",tbitemdesc);
        return "item";
    }

}
