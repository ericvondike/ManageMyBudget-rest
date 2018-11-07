package com.daklan.controlbudget.rest.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * POJO portant les attributs de configuration préfixés par "kmse".
 */
@Configuration
@PropertySource("classpath: kmse.properties")
@ConfigurationProperties(prefix = "kmse")
public class KmsProperties {

    private String protocol;
    private String domain;
    private int port;
    private String baseUrl;
    private String userName;
    private String password;
    private String realm;
    private String nonce;
    private String qop;
    private String opaque;
    private String xsiTypeName;

    private Prospect prospect = new Prospect();
//    private Tariffication tariffication = new Tariffication();


    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getQop() {
        return qop;
    }

    public void setQop(String qop) {
        this.qop = qop;
    }

    public String getOpaque() {
        return opaque;
    }

    public void setOpaque(String opaque) {
        this.opaque = opaque;
    }

    public String getXsiTypeName() {
        return xsiTypeName;
    }

    public void setXsiTypeName(String xsiTypeName) {
        this.xsiTypeName = xsiTypeName;
    }

//    public Tariffication getTariffication() {
//        return tariffication;
//    }
//
//    public void setTariffication(Tariffication tariffication) {
//        this.tariffication = tariffication;
//    }

    /**
     * POJO portant les attributs de configuration concernant le prospect.
     */
    public class Prospect {
        private String url;

        private Template template = new Template();

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Template getTemplate() {
            return template;
        }

        public void setTemplate(Template template) {
            this.template = template;
        }
    }

    /**
     * POJO portant les attributs de configuration concernant un tempalte d'appel KMS.
     */
    public class Template {
        private String filePath;
        private String kmsRequestJsonPath;
        private String insuranceProductPath;
        private String inputJsonPath;

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getKmsRequestJsonPath() {
            return kmsRequestJsonPath;
        }

        public void setKmsRequestJsonPath(String kmsRequestJsonPath) {
            this.kmsRequestJsonPath = kmsRequestJsonPath;
        }

        public String getInputJsonPath() {
            return inputJsonPath;
        }

        public void setInputJsonPath(String inputJsonPath) {
            this.inputJsonPath = inputJsonPath;
        }

        public String getInsuranceProductPath() {
            return insuranceProductPath;
        }

        public void setInsuranceProductPath(String insuranceProductPath) {
            this.insuranceProductPath = insuranceProductPath;
        }
    }

//    public class TarificationTemplate {
//
//        private String insuranceProductPath;
//        private String contributionPeriodPath;
//        private String birthDatePath;
//        private String additionalCapitalAmountPath;
//        private String kmsResponsePath;
//
//        public String getInsuranceProductPath() {
//            return insuranceProductPath;
//        }
//
//        public void setInsuranceProductPath(String insuranceProductPath) {
//            this.insuranceProductPath = insuranceProductPath;
//        }
//
//        public String getContributionPeriodPath() {
//            return contributionPeriodPath;
//        }
//
//        public void setContributionPeriodPath(String contributionPeriodPath) {
//            this.contributionPeriodPath = contributionPeriodPath;
//        }
//
//        public String getBirthDatePath() {
//            return birthDatePath;
//        }
//
//        public void setBirthDatePath(String birthDatePath) {
//            this.birthDatePath = birthDatePath;
//        }
//
//        public String getAdditionalCapitalAmountPath() {
//            return additionalCapitalAmountPath;
//        }
//
//        public void setAdditionalCapitalAmountPath(String additionalCapitalAmountPath) {
//            this.additionalCapitalAmountPath = additionalCapitalAmountPath;
//        }
//
//        public String getKmsResponsePath() {
//            return kmsResponsePath;
//        }
//
//        public void setKmsResponsePath(String kmsResponsePath) {
//            this.kmsResponsePath = kmsResponsePath;
//        }
//    }
//    public class Tariffication {
//        private String Url;
//        private Template template = new Template();
//        private TarificationTemplate tarificationTemplate = new TarificationTemplate();
//
//        public String getUrl() {
//            return Url;
//        }
//
//        public void setUrl(String url) {
//            Url = url;
//        }
//
//        public Template getTemplate() {
//            return template;
//        }
//
//        public void setTemplate(Template template) {
//            this.template = template;
//        }
//
//        public TarificationTemplate getTarificationTemplate() {
//            return tarificationTemplate;
//        }
//
//        public void setTarificationTemplate(TarificationTemplate tarificationTemplate) {
//            this.tarificationTemplate = tarificationTemplate;
//        }
//}
}