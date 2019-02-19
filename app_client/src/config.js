export const SiteName = 'Default Site Name';
export const TitleSeparator = ' - ';
export const RouterMode = 'hash';

/**
 * API configuration
 */
export const APIConfig = {
  baseURL: 'http://207.246.90.64:8080/',
  withCredentials: false,
  crossDomain: true,
  contentType: false,
  responseType: 'json',
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Access-Control-Allow-Credentials': true,
    'Access-Control-Allow-Origin': '*'
  },
};

/**
 * GOOGLE ANALYTICS PAR
 */
export const enableAnalytics = true;
export const analyticsKey = 'UA-XXX-X';
export const disableAnalyticsInDebug = true;
