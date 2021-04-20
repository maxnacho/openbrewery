Search Breweries notes: in case of absent query params we catch 500, we could cover this case if the exception was processed.

List Breweries coverage:

1. GET https://api.openbrewerydb.org/breweries (assert body structure, status code);
2. Unsupported methods requests on https://api.openbrewerydb.org/breweries (assert body structure, status code);
3. Filter by existing field value (check if response fields matches filter);
4. Filter by unexisting field value (check if response doesn't contain elements, that don't meet the search criteria);
5. Boundary values of page field;
6. Boundary values of per_page field;
7. Sort by existing field asc / desc;
8. Sort by unexisting field asc / desc;
9. Sort by existing field asc / desc using filter;
10. Sort by unexisting field asc / desc using filter;
11. Sort, using * instead of required '+' and '-'.

Estimated efford is about few hours.
