package com.alkl1m.contractor.web.controller;

import com.alkl1m.auditlogspringbootautoconfigure.annotation.AuditLog;
import com.alkl1m.contractor.domain.entitiy.OrgForm;
import com.alkl1m.contractor.service.OrgFormService;
import com.alkl1m.contractor.web.payload.NewOrgFormPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orgform")
public class OrgFormController {

    private final OrgFormService orgFormService;

    @AuditLog
    @GetMapping("/all")
    public List<OrgForm> getAllOrgForms() {
        return orgFormService.getAllOrgForms();
    }

    @AuditLog
    @GetMapping("/{id}")
    public OrgForm getOrgFormById(@PathVariable Long id) {
        return orgFormService.getOrgFormById(id);
    }

    @AuditLog
    @PutMapping("/save")
    public OrgForm saveOrgForm(@Validated @RequestBody NewOrgFormPayload payload) {
        return orgFormService.saveOrgForm(payload);
    }

    @AuditLog
    @DeleteMapping("/delete/{id}")
    public void deleteOrgForm(@PathVariable Long id) {
        orgFormService.deleteOrgForm(id);
    }

}