import React from 'react';

import './styles.css';

type Props = {
  totalPages?: number;
  goToPage: Function;
  activePage: number;
};

const Pagination = ({ totalPages = 0, goToPage, activePage }: Props) => {
  const paginationItems = Array.from(Array(totalPages).keys());

  return (
    <div className="pagination-container">
      {/* Botão de voltar */}
      <button
        className={`pagination-item ${activePage > 0 ? 'active' : 'inactive'}`}
        onClick={activePage > 0 ? () => goToPage(activePage - 1) : () => {}}
      >
        {'<'}
      </button>

      {/* Páginas */}
      {paginationItems.map((item) => (
        <button
          key={item}
          className={`pagination-item ${
            activePage === item ? 'active' : 'inactive'
          }`}
          onClick={() => goToPage(item)}
        >
          {item + 1}
        </button>
      ))}

      {/* Botão de avançar */}
      <button
        className={`pagination-item ${
          activePage < totalPages - 1 ? 'active' : 'inactive'
        }`}
        onClick={
          activePage < totalPages - 1
            ? () => goToPage(activePage + 1)
            : () => {}
        }
      >
        {'>'}
      </button>
    </div>
  );
};

export default Pagination;
