package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ltp.globalsuperstore.service.StoreService;

@Controller
public class StoreController {

    StoreService storeService = new StoreService();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getIndexFromId(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new Item() : items.get(index));
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
        if (item.getPrice() < item.getDiscount()) {
            result.rejectValue("price", "", "Price cannot be less than discount");
        }
        if (result.hasErrors()) return "form";
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            items.add(item);
        } else if (within5Days(item.getDate(), items.get(index).getDate())) {
            items.set(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }


   



}
