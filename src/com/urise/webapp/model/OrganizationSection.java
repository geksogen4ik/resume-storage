package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

/**
 * Created by Sveta on 22.10.2016.
 */
public class OrganizationSection extends Section {

    private final List<Organization> organizations;


    public OrganizationSection(List<Organization> organizations, List<Organization> organizations1) {
        this.organizations = organizations1;
        Objects.requireNonNull(organizations, "Organizations must not be null");

    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        return "OrganizationSection{}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organizations.equals(that.organizations);

    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }
}
