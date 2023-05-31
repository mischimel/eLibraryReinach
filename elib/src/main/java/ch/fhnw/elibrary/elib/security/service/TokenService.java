// Security part not implemented, as requirements for assignment changed

// package ch.fhnw.elibrary.elib.security.service;

// // import org.springframework.security.core.Authentication;
// // import org.springframework.security.core.GrantedAuthority;
// // TODO: commentet out, as import where throwing errors
// /*
// import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
// import org.springframework.security.oauth2.jwt.JwsHeader;
// import org.springframework.security.oauth2.jwt.JwtClaimsSet;
// import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
// */
// import org.springframework.stereotype.Service;
// // import java.time.Instant;
// // import java.time.temporal.ChronoUnit;
// // import java.util.stream.Collectors;

// // TokenService class derived from CRM-webservice example
// // author @michimel

// @Service
// public class TokenService {

//     // TODO: check if TokenService is needed
//     /*
//      * private final JwtEncoder encoder;
//      * 
//      * public TokenService(JwtEncoder encoder) {
//      * this.encoder = encoder;
//      * }
//      * 
//      * public String generateToken(Authentication authentication) {
//      * Instant now = Instant.now();
//      * String scope = authentication.getAuthorities().stream()
//      * .map(GrantedAuthority::getAuthority)
//      * .filter(authority -> !authority.startsWith("ROLE"))
//      * .collect(Collectors.joining(" "));
//      * JwtClaimsSet claims = JwtClaimsSet.builder()
//      * .issuer("self")
//      * .issuedAt(now)
//      * .expiresAt(now.plus(1, ChronoUnit.HOURS))
//      * .subject(authentication.getName())
//      * .claim("scope", scope)
//      * .build();
//      * var encoderParameters =
//      * JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS512).build(),
//      * claims);
//      * return this.encoder.encode(encoderParameters).getTokenValue();
//      * }
//      */

// }