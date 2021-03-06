/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AuthorizedConnectApp extends Resource {
    private static final long serialVersionUID = 67218777245125L;

    public enum Permission {
        GET_ALL("get-all"),
        POST_ALL("post-all");

        private final String value;

        private Permission(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Permission from a string.
         * @param value string value
         * @return generated Permission
         */
        @JsonCreator
        public static Permission forValue(final String value) {
            return Promoter.enumFromString(value, Permission.values());
        }
    }

    /**
     * Create a AuthorizedConnectAppFetcher to execute fetch.
     *
     * @param pathAccountSid The SID of the Account that created the resource to
     *                       fetch
     * @param pathConnectAppSid The SID of the Connect App to fetch
     * @return AuthorizedConnectAppFetcher capable of executing the fetch
     */
    public static AuthorizedConnectAppFetcher fetcher(final String pathAccountSid,
                                                      final String pathConnectAppSid) {
        return new AuthorizedConnectAppFetcher(pathAccountSid, pathConnectAppSid);
    }

    /**
     * Create a AuthorizedConnectAppFetcher to execute fetch.
     *
     * @param pathConnectAppSid The SID of the Connect App to fetch
     * @return AuthorizedConnectAppFetcher capable of executing the fetch
     */
    public static AuthorizedConnectAppFetcher fetcher(final String pathConnectAppSid) {
        return new AuthorizedConnectAppFetcher(pathConnectAppSid);
    }

    /**
     * Create a AuthorizedConnectAppReader to execute read.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @return AuthorizedConnectAppReader capable of executing the read
     */
    public static AuthorizedConnectAppReader reader(final String pathAccountSid) {
        return new AuthorizedConnectAppReader(pathAccountSid);
    }

    /**
     * Create a AuthorizedConnectAppReader to execute read.
     *
     * @return AuthorizedConnectAppReader capable of executing the read
     */
    public static AuthorizedConnectAppReader reader() {
        return new AuthorizedConnectAppReader();
    }

    /**
     * Converts a JSON String into a AuthorizedConnectApp object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AuthorizedConnectApp object represented by the provided JSON
     */
    public static AuthorizedConnectApp fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AuthorizedConnectApp.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AuthorizedConnectApp object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AuthorizedConnectApp object represented by the provided JSON
     */
    public static AuthorizedConnectApp fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AuthorizedConnectApp.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String connectAppCompanyName;
    private final String connectAppDescription;
    private final String connectAppFriendlyName;
    private final URI connectAppHomepageUrl;
    private final String connectAppSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final List<AuthorizedConnectApp.Permission> permissions;
    private final String uri;

    @JsonCreator
    private AuthorizedConnectApp(@JsonProperty("account_sid")
                                 final String accountSid,
                                 @JsonProperty("connect_app_company_name")
                                 final String connectAppCompanyName,
                                 @JsonProperty("connect_app_description")
                                 final String connectAppDescription,
                                 @JsonProperty("connect_app_friendly_name")
                                 final String connectAppFriendlyName,
                                 @JsonProperty("connect_app_homepage_url")
                                 final URI connectAppHomepageUrl,
                                 @JsonProperty("connect_app_sid")
                                 final String connectAppSid,
                                 @JsonProperty("date_created")
                                 final String dateCreated,
                                 @JsonProperty("date_updated")
                                 final String dateUpdated,
                                 @JsonProperty("permissions")
                                 final List<AuthorizedConnectApp.Permission> permissions,
                                 @JsonProperty("uri")
                                 final String uri) {
        this.accountSid = accountSid;
        this.connectAppCompanyName = connectAppCompanyName;
        this.connectAppDescription = connectAppDescription;
        this.connectAppFriendlyName = connectAppFriendlyName;
        this.connectAppHomepageUrl = connectAppHomepageUrl;
        this.connectAppSid = connectAppSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.permissions = permissions;
        this.uri = uri;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The company name set for the Connect App.
     *
     * @return The company name set for the Connect App
     */
    public final String getConnectAppCompanyName() {
        return this.connectAppCompanyName;
    }

    /**
     * Returns A detailed description of the app.
     *
     * @return A detailed description of the app
     */
    public final String getConnectAppDescription() {
        return this.connectAppDescription;
    }

    /**
     * Returns The name of the Connect App.
     *
     * @return The name of the Connect App
     */
    public final String getConnectAppFriendlyName() {
        return this.connectAppFriendlyName;
    }

    /**
     * Returns The public URL for the Connect App.
     *
     * @return The public URL for the Connect App
     */
    public final URI getConnectAppHomepageUrl() {
        return this.connectAppHomepageUrl;
    }

    /**
     * Returns The SID that we assigned to the Connect App.
     *
     * @return The SID that we assigned to the Connect App
     */
    public final String getConnectAppSid() {
        return this.connectAppSid;
    }

    /**
     * Returns The RFC 2822 date and time in GMT that the resource was created.
     *
     * @return The RFC 2822 date and time in GMT that the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The RFC 2822 date and time in GMT that the resource was last updated.
     *
     * @return The RFC 2822 date and time in GMT that the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns Permissions authorized to the app.
     *
     * @return Permissions authorized to the app
     */
    public final List<AuthorizedConnectApp.Permission> getPermissions() {
        return this.permissions;
    }

    /**
     * Returns The URI of the resource, relative to `https://api.twilio.com`.
     *
     * @return The URI of the resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthorizedConnectApp other = (AuthorizedConnectApp) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(connectAppCompanyName, other.connectAppCompanyName) &&
               Objects.equals(connectAppDescription, other.connectAppDescription) &&
               Objects.equals(connectAppFriendlyName, other.connectAppFriendlyName) &&
               Objects.equals(connectAppHomepageUrl, other.connectAppHomepageUrl) &&
               Objects.equals(connectAppSid, other.connectAppSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(permissions, other.permissions) &&
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            connectAppCompanyName,
                            connectAppDescription,
                            connectAppFriendlyName,
                            connectAppHomepageUrl,
                            connectAppSid,
                            dateCreated,
                            dateUpdated,
                            permissions,
                            uri);
    }
}