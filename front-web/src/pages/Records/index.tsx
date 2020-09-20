import React, { useEffect, useState } from 'react';
import axios from 'axios';

import Pagination from './Pagination';
import { RecordsResponse } from './types';
import { formatDate } from './helpers';

import './styles.css';
import { Link } from 'react-router-dom';

const BASE_URL = 'http://localhost:8080';

const Records = () => {
  const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
  const [activePage, setActivePage] = useState(0);

  useEffect(() => {
    (async () => {
      const response = await axios.get(
        `${BASE_URL}/records?linesPerPage=12&page=${activePage}`
      );
      setRecordsResponse(response.data);
    })();
  }, [activePage]);

  const handlePageChange = (index: number) => {
    setActivePage(index)
  }

  return (
    <div className="page-container">
      <div className="filters-container records-actions">
        <Link to="/charts">
          <button className="action-filters">
            Ver Gráficos
          </button>
        </Link>
      </div>

      <table className="records-table" cellPadding={0} cellSpacing={0}>
        <thead>
          <tr>
            <th>Instante</th>
            <th>Nome</th>
            <th>Idade</th>
            <th>Plataforma</th>
            <th>Gênero</th>
            <th>Título do Game</th>
          </tr>
        </thead>
        <tbody>
          {recordsResponse?.content.map((record) => (
            <tr key={record.id}>
              <td>{formatDate(record.moment)}</td>
              <td>{record.name}</td>
              <td>{record.age}</td>
              <td className="text-secondary">{record.gamePlatform}</td>
              <td>{record.genreName}</td>
              <td className="text-primary">{record.gameTitle}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <Pagination totalPages={recordsResponse?.totalPages} goToPage={handlePageChange} activePage={activePage} />
    </div>
  );
};

export default Records;
