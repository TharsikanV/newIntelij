//package com.finalProject.finalProject.comman;
//
////public class CorsConfig {
////}
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.servlet.config.annotation.CorsRegistry;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////
////@Configuration
////public class CorsConfig implements WebMvcConfigurer {
////
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedOrigins("http://localhost:3000")
////                .allowedMethods("GET", "POST")
////                .allowedHeaders("Content-Type", "Authorization");
////    }
////}
//import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.web.cors.CorsConfiguration;
//        import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//        import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig {
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*"); // Allow all origins
//        config.addAllowedMethod("*"); // Allow all HTTP methods
//        config.addAllowedHeader("Content-Type"); // Allow only Content-Type header
//        config.addAllowedHeader("Authorization"); // Allow Authorization header
//        // Add more headers as needed
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}
//
