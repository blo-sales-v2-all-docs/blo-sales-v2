package com.blo.sales.v2.model.constants;

public final class BloSalesV2Queries {
    
    private BloSalesV2Queries() { }
    
    /** users */
    public static final String SELECT_ONLY_ID_USERS = "SELECT id_user FROM users WHERE username = ? LIMIT 1";
    
    public static final String SELECT_USER_ROL = "SELECT rol, username, id_user FROM users WHERE username = ? AND password = ?";
    
    public static final String SELECT_ID_FROM_USER = "SELECT id_user, rol, username FROM users WHERE id_user = ? LIMIT 1";
    
    /** categories */
    public static final String INSERT_CATEGORY = "INSERT INTO categories(category, description) VALUES (?, ?)";
    
    public static final String SELECT_ALL_DATA_FROM_CATEGORIES = "SELECT id_category, category, description FROM categories";
    
    public static final String SELECT_CATEGORY = "SELECT id_category, category, description FROM categories WHERE id_category = ?";
    
    public static final String UPDATE_CATEGORY = "UPDATE categories SET category = ?, description = ? WHERE id_category = ?";
    
    /** products */
    public static final String INSERT_PRODUCT = "INSERT INTO stock(product, quantity, cost_of_sale, price, timestamp, is_kg, bar_code, fk_category) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    public static final String SELECT_ALL_PRODUCTS = "SELECT id_product, product, quantity, cost_of_sale, price, timestamp, is_kg, bar_code, fk_category FROM stock";
    
    public static final String UPDATE_PRODUCT = "UPDATE stock SET product = ?, quantity = ?, cost_of_sale = ?, timestamp = ?, bar_code = ?, price = ? WHERE id_product = ?";
    
    public static final String SELECT_ONE_PRODUCT = "SELECT id_product, product, quantity, cost_of_sale, price, timestamp, is_kg, bar_code, fk_category FROM stock WHERE id_product = ?";
    
    public static final String SELECT_PRODUCT_BY_BAR_CODE = "SELECT id_product, product, quantity, cost_of_sale, price, timestamp, is_kg, bar_code, fk_category FROM stock WHERE bar_code = ?";
    
    /** historial */
    public static final String INSERT_MOVEMENT = "INSERT INTO history(fk_product, fk_user, type, quantity, reason, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
    
    public static final String SELECT_MOVEMENTS_DETAIL = "SELECT h.id_movement, h.type, h.reason, st.id_product, st.product, h.timestamp, u.username, h.quantity FROM history h INNER JOIN stock st ON h.fk_product = st.id_product INNER JOIN users u ON h.fk_user = u.id_user WHERE st.id_product = ?";
    
    /** ventas */
    public static final String INSERT_SALE = "INSERT INTO sales(total, sale_status, timestamp, total_cash, total_card, payment_type, authorization) VALUES (?, ?, ?, ?, 0, 'CASH', 'N/A')";
    
    public static final String SELECT_SALE_BY_STATUS = "SELECT id_sale, total, sale_status, timestamp FROM sales WHERE sale_status = ?";
    
    public static final String SET_ON_CASHBOX = "UPDATE sales SET sale_status = 'ON_CASHBOX' WHERE id_sale = ?";
    
    public static final String ADD_PAYMENT_BY_CARD = "UPDATE sales SET payment_type = ?, authorization = ?, total_cash = ?, total_card = ? WHERE id_sale = ?";
    
    /** ventas product */
    public static final String INSERT_SALE_PRODUCT = "INSERT INTO sale_product(fk_sale, fk_product, quantity_sale, total_on_sale, product_total_on_sale, timestamp, is_live) VALUES (?, ?, ?, ?, ?, ?, true)";
    
    public static final String SELECT_SALES_DETAIL = "SELECT s.id_sale, st.id_product, st.product, ps.quantity_sale, st.price, st.cost_of_sale, ps.total_on_sale, ps.timestamp, st.is_kg, ps.product_total_on_sale, s.payment_type FROM sales s INNER JOIN sale_product ps ON s.id_sale = ps.fk_sale INNER JOIN stock st ON ps.fk_product = st.id_product AND ps.is_live = true";
    
    public static final String SELECT_SALE_CLOSED = "SELECT s.id_sale, st.id_product, st.product, ps.quantity_sale, st.price, st.cost_of_sale, ps.total_on_sale, ps.timestamp, ps.product_total_on_sale, s.payment_type FROM sales s INNER JOIN sale_product ps ON s.id_sale = ps.fk_sale INNER JOIN stock st ON ps.fk_product = st.id_product WHERE s.sale_status = ? AND ps.is_live = 1";
    
    public static final String SELECT_SALES_PRODUCT = "SELECT sp.id_sale_product, sp.fk_sale, sp.fk_product, sp.quantity_sale, sp.total_on_sale, sp.product_total_on_sale, sp.timestamp, sp.is_live FROM sale_product sp WHERE sp.fk_sale = ? AND sp.fk_product = ?";
    
    public static final String SELECT_SALES_PRODUCT_BY_FK_SALE = "SELECT sp.id_sale_product, sp.fk_sale, sp.fk_product, sp.quantity_sale, sp.total_on_sale, sp.product_total_on_sale, sp.timestamp, sp.is_live FROM sale_product sp WHERE sp.fk_sale = ? AND sp.is_live = true";
    
    public static final String UPDATE_SALE_PRODUCT_RELATIONSHIP = "UPDATE sale_product SET quantity_sale = ?, total_on_sale = ?, product_total_on_sale = ?, timestamp = ?, is_live = ? WHERE id_sale_product = ?";
    
    /** cajas de dinero */
    public static final String INSERT_CASHBOX = "INSERT INTO cashboxes(fk_user, timestamp, status, amount) VALUES (?, ?, ?, ?)";
    
    public static final String UPDATE_CASHBOX = "UPDATE cashboxes SET timestamp = ?, status = ?, amount = ? WHERE id_cashbox = ?";
    
    //public static final String SELECT_OPEN_CASHBOX = "SELECT id_cashbox, fk_user, timestamp, status, amount FROM cashboxes WHERE status = ? LIMIT 1";
    public static final String SELECT_OPEN_CASHBOX = "SELECT id_cashbox, fk_user, timestamp, status, amount, username FROM cashboxes c INNER JOIN users u WHERE c.fk_user = u.id_user AND status = ? LIMIT 1";
    
    public static final String SELECT_ALL_CASHBOXES_AND_USERS = "SELECT id_cashbox, fk_user, timestamp, status, amount, username FROM cashboxes c INNER JOIN users u WHERE c.fk_user = u.id_user";
    
    /** deudores */
    public static final String INSERT_DEBTOR = "INSERT INTO debtors(name, debt, payments) VALUES (?, ?, ?)";
    
    public static final String SELECT_DEBTOR_BY_ID = "SELECT id_debtor, name, debt, payments FROM debtors WHERE id_debtor = ?";
    
    public static final String SELECT_DEBTORS = "SELECT id_debtor, name, debt, payments FROM debtors";
    
    public static final String UPDATE_DEBTOR = "UPDATE debtors SET name = ?, debt = ?, payments = ? WHERE id_debtor = ?";
    
    public static final String DEBTORS_DETAILS = "SELECT d.id_debtor, d.name, d.debt, d.payments, st.product, sp.quantity_sale, sp.total_on_sale, sp.timestamp FROM debtors d INNER JOIN debtor_sale ds ON ds.fk_debtor = d.id_debtor INNER JOIN sales s ON ds.fk_sale = s.id_sale INNER JOIN sale_product sp ON sp.fk_sale = s.id_sale INNER JOIN stock st ON st.id_product = sp.fk_product";
    
    public static final String DEBTOR_DELETE = "DELETE FROM debtors WHERE id_debtor = ?";
    
    /** deudores ventas */
    public static final String INSERT_DEBTOR_SALE = "INSERT INTO debtor_sale(fk_debtor, fk_sale, timestamp) VALUES (?, ?, ?)";

    public static final String DELETE_DEBTOR_SALE = "DELETE FROM debtor_sale WHERE debtor_sale.fk_debtor = ?";
    
    public static final String SELECT_DEBTOR_SALE_PRODUCTS_INFO = "SELECT d.id_debtor, d.name, s.id_sale, s.timestamp, s.payment_type, s.authorization, s2.product, d.payments FROM debtors d INNER JOIN debtor_sale ds ON d.id_debtor=ds.fk_debtor INNER JOIN sales s ON s.id_sale = ds.fk_sale INNER JOIN sale_product sp ON sp.fk_sale = s.id_sale INNER JOIN stock s2 ON s2.id_product = sp.fk_product WHERE sp.is_live = TRUE AND d.id_debtor = ?";
    /** activos pasivos */
    public static final String INSERT_ACTIVE_COSTS = "INSERT INTO actives_costs(concept, amount, type, complete) VALUES (?, ?, ?, ?)";
    
    /** relacion activos pasivos con caja de dinero */
    public static final String INSERT_CASHBOXES_ACTIVE_COSTS = "INSERT INTO cashboxes_actives_costs(fk_cashbox, fk_actives_costs, timestamp) VALUES (?, ?, ?)";
    
    public static final String SELECT_CASHBOXES_DATA = "SELECT c.id_cashbox, c.status, c.amount, ac.concept, ac.type, cac.timestamp, ac.amount AS concept_amount FROM cashboxes c INNER JOIN cashboxes_actives_costs cac ON c.id_cashbox = cac.fk_cashbox INNER JOIN actives_costs ac ON cac.fk_actives_costs = ac.id_active_cost";
    
    /** notas */
    public static final String INSERT_NOTES = "INSERT INTO notes(note, timestamp, type_note, fk_user) VALUES (?, ?, ?, ?)";
    
    public static final String GET_NOTES_BY_ID_USER = "SELECT id_note, note, timestamp, type_note, fk_user FROM notes WHERE fk_user = ?";
    
    public static final String DELETE_NOTE = "DELETE FROM notes WHERE notes.id_note = ?";
    
    public static final String UPDATE_NOTE = "UPDATE notes SET notes.note = ?, timestamp = ? wHERE notes.id_note = ?";
    
    /** hsitorial de precios */
    public static final String INSERT_PRICE_HISTORY_ITEM = "INSERT INTO prices_history(price, cost_of_sale) VALUES (?, ?)";
    
    public static final String INSERT_PRICE_HISTORY_RELATIONSHIP = "INSERT INTO stock_prices_history(fk_product, fk_price_history, timestamp) VALUES(?, ?, ?)";
    
    public static final String RETRIEVE_STOCK_PRICE_HISTORY = "SELECT sph.id_stock_price_history, sph.timestamp, s.product, ph.price, ph.cost_of_sale FROM stock_prices_history sph INNER JOIN stock s ON sph.fk_product = s.id_product INNER JOIN prices_history ph ON ph.id_price_history = sph.fk_price_history WHERE s.id_product = ?";
    
    public static final String INSERT_SALE_DELETED_DETAIL = "INSERT INTO sale_deleted_detail(fk_sale_product, fk_user, reason, timestamp) VALUES (?, ?, ?, ?)";
    
    public static final String SELECT_DELETEDS_SALES_DETAIL = "SELECT sdd.id_sale_deleted, sdd.fk_sale_product, s.product, sdd.reason, u.username, sdd.fk_user , sdd.timestamp  FROM sale_deleted_detail sdd  INNER JOIN sale_product sp ON sp.id_sale_product = sdd.fk_sale_product INNER JOIN stock s ON s.id_product = sp.fk_product INNER JOIN users u ON u.id_user = sdd.fk_user";
    
    /** compañia telefonica */
    public static final String INSERT_MOBILE_COMPANY = "INSERT INTO mobile_company(company) VALUES (?)";
    
    public static final String RETRIEVE_ALL_MOBILES_COMPANIES = "SELECT id_mobile_company, company FROM mobile_company";
    
    public static final String RETRIEVE_MOBILE_COMPANY_BY_ID = "SELECT id_mobile_company, company FROM mobile_company WHERE id_mobile_company = ?";
    
    public static final String UPDATE_MOBILE_COMPANY = "UPDATE mobile_company SET company = ? WHERE id_mobile_company = ?";
    
    /** recargas telefonicas */
    public static final String INSERT_TOP_UP = "INSERT INTO top_up(fk_user, fk_mobile_company, amount, checked, phone_number, timestamp, authorization) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    public static final String UPDATE_TP_UP = "UPDATE top_up SET fk_user = ?, fk_mobile_company = ?, amount = ?, checked = ?, phone_number = ?, timestamp = ?, authorization = ? WHERE id_top_up = ?";
    
    public static final String SELECT_TOP_UPS_BY_STATUS = "SELECT id_top_up, fk_user, fk_mobile_company, amount, checked, phone_number, timestamp, username, id_user, rol, id_mobile_company, company, authorization FROM top_up INNER JOIN users ON top_up.fk_user = users.id_user INNER JOIN mobile_company ON mobile_company.id_mobile_company = top_up.fk_mobile_company WHERE top_up.checked = ?";
    
    public static final String SELECT_ALL_TOP_UP = "SELECT id_top_up, fk_user, fk_mobile_company, amount, checked, phone_number, timestamp, username, id_user, rol, id_mobile_company, company, authorization FROM top_up INNER JOIN users ON top_up.fk_user = users.id_user INNER JOIN mobile_company ON mobile_company.id_mobile_company = top_up.fk_mobile_company";
    
    /** sales-cashboxes */
    public static final String INSERT_CASHBOX_SALE_RELATIONSHIP = "INSERT INTO cashboxes_sales(fk_cashbox, fk_sale) VALUES(?,?)";
    
    public static final String GET_CASHBOXES_ALL_DATA_DETAIL_BY_CASHBOX_ID = "SELECT c.id_cashbox , c.fk_user, c.amount, c.status, c.timestamp AS cb_timestamp, s.id_sale, s.total, s.sale_status, s.timestamp, s2.product, sp.quantity_sale, sp.product_total_on_sale, sp.total_on_sale, u.username, u.rol, s.payment_type, s.authorization, s.total_card, s.total_cash FROM cashboxes_sales cs INNER JOIN cashboxes c ON cs.fk_cashbox  = c.id_cashbox  INNER JOIN sales s ON s.id_sale  = cs.fk_sale INNER JOIN sale_product sp INNER JOIN stock s2 ON sp.fk_product  = s2.id_product ON sp.fk_sale = s.id_sale INNER JOIN users u ON u.id_user = c.fk_user  WHERE c.id_cashbox = ?";
    
    public static final String GET_CASHBOX_SALE_DATA_BY_ID = "SELECT c.id_cashbox , c.fk_user, c.amount, c.timestamp, c.status, s.id_sale, s.total, s.sale_status, s.timestamp  FROM cashboxes_sales cs INNER JOIN cashboxes c ON cs.fk_cashbox  = c.id_cashbox  INNER JOIN sales s ON s.id_sale  = cs.fk_sale WHERE c.id_cashbox  = ?";
    
    /** settlements (pagos) */
    public static final String INSERT_SETTLEMENT = "INSERT INTO debt_settlements(fk_sale, debtor, products_details, payments, timestamp) VALUES(?, ?, ?, ?, ?)";
    
    public static final String SELECT_SETTLEMENTS_INFO = "SELECT id_debt_settlement, fk_sale, debtor, products_details, payments, timestamp FROM debt_settlements";
    
    /** accounts */
    public static final String SELECT_ACCOUNT = "SELECT id_account, account, control_amount, timestamp FROM accounts WHERE id_account = ? LIMIT 1";
    
    public static final String UPDATE_ACCOUNT = "UPDATE accounts SET account = ?, control_amount = ?, timestamp =? WHERE id_account = ?";
    
    public static final String INSERT_FINANCIAL_MOVEMENT = "INSERT INTO financial_history(fk_account, fk_user, amount, reason, type, timestamp) values(?, ?, ?, ?, ?, ?)";
    
    public static final String SELECT_DIGITAL_WALLET = "SELECT id_financial_movement, amount, reason, type, fh.timestamp FROM financial_history fh INNER JOIN accounts a ON fh.fk_account = a.id_account WHERE a.id_account = ?";
}
