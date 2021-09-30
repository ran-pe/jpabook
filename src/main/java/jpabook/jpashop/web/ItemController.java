package jpabook.jpashop.web;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/items/new")
    public String createForm() {
        return "items/createItemForm";
    }

    @PostMapping(value = "/items/new")
    public String create(Book item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    /**
     * 상품 목록
     * @param model
     * @return
     */
    @GetMapping(value = "/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "itmes/itemList";
    }

    /**
     * 상품 수정 폼
     *
     * @param itemId
     * @param model
     * @return
     */
    @GetMapping(value = "/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.findOne(itemId);
        model.addAttribute("item", item);
        return "items/updateItemForm";
    }

    /**
     * 상품 수정
     *
     * @param item
     * @return
     */
    @PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("item") Book item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

}
