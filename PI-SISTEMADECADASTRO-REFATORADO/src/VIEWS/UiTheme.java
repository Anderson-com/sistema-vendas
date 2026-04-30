/*package VIEWS;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

public final class UiTheme {

    private static final Color WINDOW_BG = new Color(241, 245, 249);
    private static final Color PANEL_BG = Color.WHITE;
    private static final Color TEXT_COLOR = new Color(15, 23, 42);
    private static final Color BUTTON_TEXT = Color.WHITE;
    private static final Color BUTTON_BG = new Color(2, 132, 199);
    private static final Color FIELD_BG = new Color(248, 250, 252);
    private static final Color FIELD_BORDER = new Color(203, 213, 225);
    private static final Color TABLE_HEADER_BG = new Color(241, 245, 249);
    private static final Font BASE_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    private UiTheme() {
    }

    public static void apply(JFrame frame) {
        frame.getContentPane().setBackground(WINDOW_BG);
        if (frame.getContentPane().getComponentCount() == 1
                && frame.getContentPane().getComponent(0) instanceof JPanel mainPanel) {
            mainPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        }
        styleComponent(frame.getContentPane());
        frame.pack();
    }

    private static void styleComponent(Component component) {
        if (component instanceof JPanel panel) {
            panel.setBackground(PANEL_BG);
        }

        if (component instanceof JLabel label) {
            label.setForeground(TEXT_COLOR);
            if (label.getHorizontalAlignment() == SwingConstants.CENTER && label.getFont().getSize() >= 30) {
                label.setFont(BASE_FONT.deriveFont(Font.BOLD, 34f));
            } else if (label.getFont().getSize() >= 18) {
                label.setFont(BASE_FONT.deriveFont(Font.BOLD, 16f));
            } else {
                label.setFont(BASE_FONT.deriveFont(Font.PLAIN, 14f));
            }
        }

        if (component instanceof JButton button) {
            styleButton(button);
        }

        if (component instanceof JTextField textField) {
            styleTextField(textField);
        }

        if (component instanceof JFormattedTextField formattedTextField) {
            styleTextField(formattedTextField);
        }

        if (component instanceof JPasswordField passwordField) {
            styleTextField(passwordField);
        }

        if (component instanceof JComboBox<?> comboBox) {
            comboBox.setBackground(FIELD_BG);
            comboBox.setForeground(TEXT_COLOR);
            comboBox.setFont(BASE_FONT.deriveFont(Font.PLAIN, 14f));
            comboBox.setBorder(fieldBorder());
        }

        if (component instanceof JTable table) {
            table.setRowHeight(26);
            table.setFont(BASE_FONT.deriveFont(Font.PLAIN, 13f));
            table.setGridColor(new Color(226, 232, 240));
            table.setSelectionBackground(new Color(224, 242, 254));
            table.setSelectionForeground(TEXT_COLOR);
            JTableHeader header = table.getTableHeader();
            if (header != null) {
                header.setBackground(TABLE_HEADER_BG);
                header.setForeground(TEXT_COLOR);
                header.setFont(BASE_FONT.deriveFont(Font.BOLD, 13f));
            }
        }

        if (component instanceof JScrollPane scrollPane) {
            scrollPane.setBorder(BorderFactory.createLineBorder(FIELD_BORDER));
            JViewport viewport = scrollPane.getViewport();
            if (viewport != null) {
                viewport.setBackground(FIELD_BG);
            }
        }

        if (component instanceof Container container) {
            for (Component child : container.getComponents()) {
                styleComponent(child);
            }
        }
    }

    private static void styleButton(JButton button) {
        String text = button.getText() == null ? "" : button.getText().toUpperCase();
        button.setForeground(BUTTON_TEXT);

        if (text.contains("VOLTAR") || text.contains("SAIR")) {
            button.setBackground(new Color(100, 116, 139));
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(71, 85, 105)),
                    BorderFactory.createEmptyBorder(8, 14, 8, 14)
            ));
        } else if (text.contains("EXCLUIR")) {
            button.setBackground(new Color(220, 38, 38));
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(185, 28, 28)),
                    BorderFactory.createEmptyBorder(8, 14, 8, 14)
            ));
        } else {
            button.setBackground(BUTTON_BG);
            button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(3, 105, 161)),
                    BorderFactory.createEmptyBorder(8, 14, 8, 14)
            ));
        }

        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(BASE_FONT.deriveFont(Font.BOLD, 13f));
        button.setMargin(new java.awt.Insets(8, 14, 8, 14));
        if (button.getToolTipText() == null || button.getToolTipText().isBlank()) {
            button.setToolTipText(button.getText());
        }
        Dimension pref = button.getPreferredSize();
        button.setPreferredSize(new Dimension(pref.width, 40));
    }

    private static void styleTextField(JComponent field) {
        field.setBackground(FIELD_BG);
        field.setForeground(TEXT_COLOR);
        field.setFont(BASE_FONT.deriveFont(Font.PLAIN, 14f));
        field.setBorder(fieldBorder());
        Dimension pref = field.getPreferredSize();
        field.setPreferredSize(new Dimension(pref.width, 34));
    }

    private static Border fieldBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(FIELD_BORDER),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        );
    }
}*/
package VIEWS;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.JTableHeader;

/**
 * UiTheme — Dark Edition
 * Tema escuro moderno com gradientes suaves, animações e visual sofisticado.
 */
public final class UiTheme {

    // ── Paleta Principal ──────────────────────────────────────────────────────
    private static final Color BG_DEEP      = new Color(10,  12,  20);   // fundo profundo
    private static final Color BG_SURFACE   = new Color(18,  22,  36);   // superfície de cards
    private static final Color BG_ELEVATED  = new Color(26,  32,  50);   // painéis elevados
    private static final Color BG_INPUT     = new Color(22,  28,  44);   // campos de entrada

    private static final Color ACCENT_BLUE  = new Color(99,  148, 255);  // azul neon suave
    private static final Color ACCENT_CYAN  = new Color(56,  224, 199);  // ciano vibrante
    private static final Color ACCENT_GLOW  = new Color(99,  148, 255, 60); // brilho ao focar

    private static final Color TEXT_PRIMARY  = new Color(224, 230, 255); // texto principal
    private static final Color TEXT_SECONDARY= new Color(120, 140, 180); // texto secundário
    private static final Color TEXT_MUTED    = new Color(60,  75,  110); // texto apagado

    private static final Color BORDER_SUBTLE = new Color(40,  50,  80);  // borda sutil
    private static final Color BORDER_ACCENT = new Color(99,  148, 255, 80); // borda acento

    private static final Color BTN_PRIMARY   = new Color(99,  148, 255); // botão principal
    private static final Color BTN_PRIMARY_H = new Color(130, 175, 255); // hover
    private static final Color BTN_DANGER    = new Color(220, 70,  80);  // perigo
    private static final Color BTN_DANGER_H  = new Color(240, 90,  100);
    private static final Color BTN_NEUTRAL   = new Color(50,  60,  90);  // neutro
    private static final Color BTN_NEUTRAL_H = new Color(65,  78,  115);

    private static final Color TABLE_HEADER  = new Color(22,  28,  46);
    private static final Color TABLE_ALT_ROW = new Color(20,  25,  42);
    private static final Color TABLE_SEL     = new Color(99,  148, 255, 50);

    // ── Tipografia ────────────────────────────────────────────────────────────
    private static final Font FONT_TITLE  = new Font("Segoe UI", Font.BOLD,  26);
    private static final Font FONT_LABEL  = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FONT_INPUT  = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FONT_BTN    = new Font("Segoe UI", Font.BOLD,  12);
    private static final Font FONT_TABLE  = new Font("Segoe UI", Font.PLAIN, 12);
    private static final Font FONT_HEADER = new Font("Segoe UI", Font.BOLD,  12);

    private UiTheme() {}

    // ── Ponto de entrada ──────────────────────────────────────────────────────
    public static void apply(JFrame frame) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {}

        configurarScrollBar();

        frame.getContentPane().setBackground(BG_DEEP);
        estilizarComponente(frame.getContentPane());

        // Barra de título customizada (onde disponível)
        frame.setBackground(BG_DEEP);

        frame.pack();
        frame.setMinimumSize(frame.getPreferredSize());
    }

    // ── Scroll Bar escura ─────────────────────────────────────────────────────
    private static void configurarScrollBar() {
        UIManager.put("ScrollBar.thumb",            new Color(55, 70, 110));
        UIManager.put("ScrollBar.track",            BG_ELEVATED);
        UIManager.put("ScrollBar.thumbDarkShadow",  BG_ELEVATED);
        UIManager.put("ScrollBar.thumbHighlight",   new Color(75, 95, 140));
        UIManager.put("ScrollBar.thumbShadow",      new Color(40, 52, 85));
        UIManager.put("ScrollBar.background",       BG_ELEVATED);
        UIManager.put("ScrollBar.foreground",       new Color(55, 70, 110));
    }

    // ── Roteador de componentes ───────────────────────────────────────────────
    private static void estilizarComponente(Component c) {

        if (c instanceof JPanel)              estilizarPanel((JPanel) c);
        if (c instanceof JLabel)              estilizarLabel((JLabel) c);
        if (c instanceof JButton)             estilizarBotao((JButton) c);
        if (c instanceof JPasswordField)      estilizarCampo((JComponent) c);
        else if (c instanceof JFormattedTextField) estilizarCampo((JComponent) c);
        else if (c instanceof JTextField)     estilizarCampo((JComponent) c);
        if (c instanceof JComboBox)           estilizarCombo((JComboBox<?>) c);
        if (c instanceof JTable)              estilizarTabela((JTable) c);
        if (c instanceof JScrollPane)         estilizarScroll((JScrollPane) c);

        if (c instanceof Container) {
            for (Component filho : ((Container) c).getComponents()) {
                estilizarComponente(filho);
            }
        }
    }

    // ── Panel ─────────────────────────────────────────────────────────────────
    private static void estilizarPanel(JPanel p) {
        p.setBackground(BG_SURFACE);
        p.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
    }

    // ── Label ─────────────────────────────────────────────────────────────────
    private static void estilizarLabel(JLabel l) {
        int size = l.getFont().getSize();
        boolean isCenter = l.getHorizontalAlignment() == SwingConstants.CENTER;

        if (isCenter && size >= 28) {
            // Título principal
            l.setFont(FONT_TITLE);
            l.setForeground(TEXT_PRIMARY);
            l.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
        } else if (size >= 18) {
            l.setFont(FONT_LABEL.deriveFont(Font.BOLD, 14f));
            l.setForeground(TEXT_SECONDARY);
        } else {
            l.setFont(FONT_LABEL);
            l.setForeground(TEXT_SECONDARY);
        }
    }

    // ── Botão ─────────────────────────────────────────────────────────────────
    private static void estilizarBotao(final JButton b) {
        String txt = b.getText() == null ? "" : b.getText().toUpperCase();

        final Color corBase;
        final Color corHover;

        if (txt.contains("VOLTAR") || txt.contains("SAIR")) {
            corBase  = BTN_NEUTRAL;
            corHover = BTN_NEUTRAL_H;
        } else if (txt.contains("EXCLUIR") || txt.contains("DELETAR")) {
            corBase  = BTN_DANGER;
            corHover = BTN_DANGER_H;
        } else {
            corBase  = BTN_PRIMARY;
            corHover = BTN_PRIMARY_H;
        }

        b.setBackground(corBase);
        b.setForeground(Color.WHITE);
        b.setFont(FONT_BTN);
        b.setFocusPainted(false);
        b.setBorderPainted(true);
        b.setOpaque(true);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setBorder(new RoundedBorder(8, corBase.brighter()));
        b.setPreferredSize(new Dimension(
            Math.max(b.getPreferredSize().width + 24, 140), 38));

        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b.setBackground(corHover);
                b.setBorder(new RoundedBorder(8, ACCENT_BLUE));
            }
            public void mouseExited(MouseEvent e) {
                b.setBackground(corBase);
                b.setBorder(new RoundedBorder(8, corBase.brighter()));
            }
            public void mousePressed(MouseEvent e) {
                b.setBackground(corBase.darker());
            }
            public void mouseReleased(MouseEvent e) {
                b.setBackground(corHover);
            }
        });
    }

    // ── Campo de texto ────────────────────────────────────────────────────────
    private static void estilizarCampo(final JComponent c) {
        c.setBackground(BG_INPUT);
        c.setForeground(TEXT_PRIMARY);
        c.setFont(FONT_INPUT);
        if (c instanceof javax.swing.text.JTextComponent) {
            ((javax.swing.text.JTextComponent) c).setCaretColor(ACCENT_BLUE);
        }
        c.setBorder(campoBordaNormal());
        c.setPreferredSize(new Dimension(c.getPreferredSize().width, 36));

        c.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                c.setBorder(campoBordaFoco());
            }
            public void focusLost(FocusEvent e) {
                c.setBorder(campoBordaNormal());
            }
        });
    }

    private static Border campoBordaNormal() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_SUBTLE, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        );
    }

    private static Border campoBordaFoco() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ACCENT_BLUE, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        );
    }

    // ── ComboBox ──────────────────────────────────────────────────────────────
    private static void estilizarCombo(JComboBox<?> c) {
        c.setBackground(BG_INPUT);
        c.setForeground(TEXT_PRIMARY);
        c.setFont(FONT_INPUT);
        c.setBorder(campoBordaNormal());

        c.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(
                JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBackground(isSelected ? BTN_PRIMARY : BG_INPUT);
                setForeground(isSelected ? Color.WHITE : TEXT_PRIMARY);
                setFont(FONT_INPUT);
                setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
                return this;
            }
        });

        // Popup escuro
        Object popup = c.getAccessibleContext().getAccessibleChild(0);
        if (popup instanceof JComponent) {
            ((JComponent) popup).setBackground(BG_INPUT);
            ((JComponent) popup).setBorder(
                BorderFactory.createLineBorder(BORDER_ACCENT, 1));
        }
    }

    // ── Tabela ────────────────────────────────────────────────────────────────
    private static void estilizarTabela(JTable t) {
        t.setBackground(BG_SURFACE);
        t.setForeground(TEXT_PRIMARY);
        t.setFont(FONT_TABLE);
        t.setGridColor(BORDER_SUBTLE);
        t.setRowHeight(30);
        t.setSelectionBackground(TABLE_SEL);
        t.setSelectionForeground(TEXT_PRIMARY);
        t.setShowHorizontalLines(true);
        t.setShowVerticalLines(false);
        t.setIntercellSpacing(new Dimension(0, 1));

        // Linhas alternadas
        t.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                if (isSelected) {
                    setBackground(TABLE_SEL);
                    setForeground(TEXT_PRIMARY);
                } else {
                    setBackground(row % 2 == 0 ? BG_SURFACE : TABLE_ALT_ROW);
                    setForeground(TEXT_PRIMARY);
                }
                setFont(FONT_TABLE);
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                return this;
            }
        });

        JTableHeader header = t.getTableHeader();
        if (header != null) {
            header.setBackground(TABLE_HEADER);
            header.setForeground(ACCENT_BLUE);
            header.setFont(FONT_HEADER);
            header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_ACCENT));
            header.setReorderingAllowed(false);
        }
    }

    // ── ScrollPane ────────────────────────────────────────────────────────────
    private static void estilizarScroll(JScrollPane s) {
        s.setBackground(BG_SURFACE);
        s.setBorder(BorderFactory.createLineBorder(BORDER_SUBTLE, 1));
        s.getViewport().setBackground(BG_SURFACE);

        estilizarScrollBar(s.getVerticalScrollBar());
        estilizarScrollBar(s.getHorizontalScrollBar());
    }

    private static void estilizarScrollBar(JScrollBar bar) {
        if (bar == null) return;
        bar.setBackground(BG_ELEVATED);
        bar.setUI(new BasicScrollBarUI() {
            protected void configureScrollBarColors() {
                thumbColor      = new Color(55, 70, 110);
                trackColor      = BG_ELEVATED;
            }
            protected JButton createDecreaseButton(int o) { return botaoScrollVazio(); }
            protected JButton createIncreaseButton(int o) { return botaoScrollVazio(); }
        });
    }

    private static JButton botaoScrollVazio() {
        JButton b = new JButton();
        b.setPreferredSize(new Dimension(0, 0));
        b.setMinimumSize(new Dimension(0, 0));
        b.setMaximumSize(new Dimension(0, 0));
        return b;
    }

    // ── Borda arredondada ─────────────────────────────────────────────────────
    static class RoundedBorder implements Border {
        private final int radius;
        private final Color color;

        RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color  = color;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(radius + 2, radius + 4, radius + 2, radius + 4);
        }

        public boolean isBorderOpaque() { return false; }

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.draw(new RoundRectangle2D.Double(x, y, w - 1, h - 1, radius, radius));
            g2.dispose();
        }
    }

    // ── Utilitário público: painel com borda acento lateral ───────────────────
    /**
     * Retorna um painel card com borda azul à esquerda — útil para destacar
     * seções dentro de uma tela (ex: área de filtros, área de resultados).
     */
    public static JPanel criarCardPanel(String titulo) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(BG_ELEVATED);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 3, 0, 0, ACCENT_BLUE),
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));

        if (titulo != null && !titulo.isEmpty()) {
            JLabel lbl = new JLabel(titulo.toUpperCase());
            lbl.setFont(FONT_LABEL.deriveFont(Font.BOLD, 11f));
            lbl.setForeground(ACCENT_BLUE);
            lbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
            card.add(lbl, BorderLayout.NORTH);
        }

        return card;
    }

    // ── Getters de cores (para uso nas Views se necessário) ───────────────────
    public static Color getBgDeep()       { return BG_DEEP; }
    public static Color getBgSurface()    { return BG_SURFACE; }
    public static Color getBgElevated()   { return BG_ELEVATED; }
    public static Color getAccentBlue()   { return ACCENT_BLUE; }
    public static Color getAccentCyan()   { return ACCENT_CYAN; }
    public static Color getTextPrimary()  { return TEXT_PRIMARY; }
    public static Color getTextSecondary(){ return TEXT_SECONDARY; }
    public static Color getBorderSubtle() { return BORDER_SUBTLE; }
}