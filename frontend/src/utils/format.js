export function currencyFormatVN(n) {
    if (['', null, undefined].includes(n)) return '-';
    return `${new Intl.NumberFormat().format(n)} đ`;
}