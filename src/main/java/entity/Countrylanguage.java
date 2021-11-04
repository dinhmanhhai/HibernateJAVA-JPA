package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(CountrylanguagePK.class)
public class Countrylanguage {
    private String countryCode;
    private String language;
    private String isOfficial;
    private BigDecimal percentage;
    private Country countryByCountryCode;

    @Id
    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Id
    @Column(name = "Language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "IsOfficial")
    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    @Basic
    @Column(name = "Percentage")
    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countrylanguage that = (Countrylanguage) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(language, that.language) && Objects.equals(isOfficial, that.isOfficial) && Objects.equals(percentage, that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language, isOfficial, percentage);
    }

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    public Country getCountryByCountryCode() {
        return countryByCountryCode;
    }

    public void setCountryByCountryCode(Country countryByCountryCode) {
        this.countryByCountryCode = countryByCountryCode;
    }
}
